package com.onix.internship.arch.mapper

class Either<out T>(private val value: Any?) {


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



