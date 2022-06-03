package com.onix.internship.arch.mapper

class Either<out T>(val value: Any?) {

    val isSuccess: Boolean get() = value !is Failure

    val isFailure: Boolean get() = value is Failure

    fun exceptionOrNull(): Throwable? = when (value) {
        is Failure -> value.exception
        else -> null
    }

    override fun toString(): String =
        when (value) {
            is Failure -> value.toString()
            else -> "Success($value)"
        }

    companion object {
        fun <T> success(value: T): Either<T> = Either(value)

        fun <T> failure(exception: Throwable): Either<T> = Either(createFailure(exception))
    }

    class Failure(val exception: Throwable) {
        override fun equals(other: Any?): Boolean = other is Failure && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Failure($exception)"
    }
}

private fun createFailure(exception: Throwable): Any = Either.Failure(exception)

inline fun <R, reified T> Either<T>.map(transform: (value: T) -> R): Either<R> {
    return when {
        isSuccess -> Either.success(transform(value as T))
        else -> Either(value)
    }
}

inline fun <T> Either<T>.onFailure(action: (exception: Throwable) -> Unit): Either<T> {
    exceptionOrNull()?.let { action(it) }
    return this
}

inline fun <reified T> Either<T>.onSuccess(action: (value: T) -> Unit): Either<T> {
    if (isSuccess) action(value as T)
    return this
}
