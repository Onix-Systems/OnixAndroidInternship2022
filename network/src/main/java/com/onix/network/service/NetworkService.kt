package com.onix.network.service

import com.onix.network.entity.*
import com.onix.network.exception.InvalidResponseBodyException
import com.onix.network.exception.SignUpException
import com.onix.network.exception.UserNotAuthorizedException
import com.onix.network.response.Either

class NetworkService(
    private val service: ApiService,
    private val apiErrorParser: ApiErrorParser
) {

    suspend fun signUp(name: String, email: String, pass: String): Either<UserToken> {
        return try {
            val response = service.signUp(SingUpEntity(name = name, email = email, pass = pass))
            val body = response.body()
            if (!response.isSuccessful || body == null) {
                when (apiErrorParser.extractError(response)) {
                    is SignUpException -> return logIn(email, pass)
                }
                return Either.failure(InvalidResponseBodyException())
            }
            if (body.status == 401) {
                return Either.failure(UserNotAuthorizedException("Cod: 401"))
            }
            Either.success(body)
        } catch (e: Throwable) {
            Either.failure(e)
        }
    }

    private suspend fun logIn(email: String, pass: String): Either<UserToken> {
        return try {
            val response = service.logIn(LogInEntity(email, pass))
            val body = response.body()
            if (!response.isSuccessful || body == null) {
                return Either.failure(InvalidResponseBodyException())
            }
            if (body.status == 401) {
                return Either.failure(UserNotAuthorizedException("Cod: 401"))
            }
            Either.success(body)
        } catch (e: Throwable) {
            Either.failure(e)
        }
    }

    suspend fun initUser(): Either<CurrentUser> {
        return try {
            val response = service.initUser()
            val body = response.body()
            if (!response.isSuccessful || body == null) {
                return Either.failure(InvalidResponseBodyException())
            }
            Either.success(body)
        } catch (e: Throwable) {
            e.printStackTrace()
            Either.failure(e)
        }
    }

    suspend fun loadChatList(): Either<ChatChannelEntity> {
        return try {
            val response = service.loadChatChannels()
            val body = response.body()

            if (!response.isSuccessful || body == null) {
                return Either.failure(InvalidResponseBodyException("Response body is empty"))
            }
            Either.success(body)
        } catch (e: Throwable) {
            Either.failure(e)
        }
    }

}