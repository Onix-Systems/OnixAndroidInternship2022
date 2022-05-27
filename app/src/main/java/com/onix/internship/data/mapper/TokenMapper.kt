package com.onix.internship.data.mapper

import com.onix.network.entity.UserToken
import com.onix.internship.arch.mapper.Mapper
import com.onix.internship.domain.entity.UserTokenModel
import java.lang.IllegalArgumentException

class TokenMapper(private val userMapper: UserMapper) : Mapper<UserToken, UserTokenModel> {

    override fun toDomain(model: UserToken): UserTokenModel {
        val userModel = if (model.app_init.user != null) {
            userMapper.toDomain(model.app_init.user!!)
        } else throw IllegalArgumentException("")

        return UserTokenModel(
            token = model.token,
            login = model.app_init.user?.name ?: "",
            user = userModel
        )
    }
}