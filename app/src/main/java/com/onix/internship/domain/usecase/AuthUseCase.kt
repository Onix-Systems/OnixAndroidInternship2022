package com.onix.internship.domain.usecase

import com.onix.network.response.Either
import com.onix.internship.R
import com.onix.internship.arch.ext.isValidEmail
import com.onix.internship.arch.provider.TextResProvider
import com.onix.internship.arch.provider.model.TextProvider
import com.onix.internship.data.repository.AuthRepository
import com.onix.internship.domain.entity.UserTokenModel

class AuthUseCase(
    private val authRepository: AuthRepository,
    private val textProvider: TextResProvider
) {

    suspend fun signUp(name: String, email: String, pass: String): Either<UserTokenModel> {
        return try {
            val mName = name.trim()
            val mEmail = email.trim()
            val mPass = pass.trim()

            if (mName.isBlank()) {
                return Either.failure(
                    IllegalArgumentException(
                        textProvider.getString(TextProvider.ResText(R.string.err_empty_name))
                    )
                )
            }
            if (mEmail.isBlank() || mEmail.isValidEmail().not()) {
                return Either.failure(
                    IllegalArgumentException(
                        textProvider.getString(TextProvider.ResText(R.string.err_empty_email))
                    )
                )
            }
            if (mPass.isBlank()) {
                return Either.failure(
                    IllegalArgumentException(
                        textProvider.getString(TextProvider.ResText(R.string.err_empty_pass))
                    )
                )
            }
            authRepository.signUp(mName, mEmail, mPass)
        } catch (e: Throwable) {
            Either.failure(e)
        }
    }

}