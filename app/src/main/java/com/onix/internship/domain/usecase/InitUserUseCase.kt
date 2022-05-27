package com.onix.internship.domain.usecase

import com.onix.network.response.Either
import com.onix.internship.R
import com.onix.internship.arch.provider.TextResProvider
import com.onix.internship.arch.provider.model.TextProvider
import com.onix.internship.data.repository.AuthRepository
import com.onix.internship.domain.entity.UserModel

class InitUserUseCase(
    private val authRepository: AuthRepository,
    private val textProvider: TextResProvider
) {

    suspend fun initUser(token: String): Either<UserModel> {
        return try {
            if (token.isBlank()) {
                return Either.failure(IllegalArgumentException(
                    textProvider.getString(TextProvider.ResText(R.string.err_empty_token))
                ))
            }

            authRepository.initUser()
        } catch (e: Throwable) {
            Either.failure(e)
        }
    }

}