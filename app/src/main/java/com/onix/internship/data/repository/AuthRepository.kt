package com.onix.internship.data.repository

import com.onix.network.response.Either
import com.onix.network.response.map
import com.onix.network.service.NetworkService
import com.onix.internship.data.mapper.TokenMapper
import com.onix.internship.data.mapper.UserMapper
import com.onix.internship.domain.entity.UserModel
import com.onix.internship.domain.entity.UserTokenModel
import java.lang.Exception

interface AuthRepository {
    suspend fun signUp(name: String, email: String, pass: String): Either<UserTokenModel>
    suspend fun initUser(): Either<UserModel>
}

class AuthRepositoryImpl(
    private val networkService: NetworkService,
    private val tokenMapper: TokenMapper,
    private val userMapper: UserMapper
) : AuthRepository {

    override suspend fun signUp(name: String, email: String, pass: String): Either<UserTokenModel> {
        return try {
            networkService.signUp(name, email, pass)
                .map { tokenMapper.toDomain(it) }
        } catch (e: Throwable) {
            e.printStackTrace()
            Either.failure(e)
        }
    }

    override suspend fun initUser(): Either<UserModel> {
        return try {
            networkService.initUser().map {
                it.user?.let { user ->
                    userMapper.toDomain(user)
                } ?: run {
                    throw Exception("Something went wrong")
                }
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            Either.failure(e)
        }
    }

}