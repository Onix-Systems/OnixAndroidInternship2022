package com.onix.internship.data.mapper

import com.onix.network.entity.User
import com.onix.internship.arch.mapper.Mapper
import com.onix.internship.domain.entity.UserModel

class UserMapper : Mapper<User, UserModel> {

    override fun toDomain(model: User): UserModel {
        return UserModel(
            id = model.id ?: 0,
            name = model.name ?: "",
            nick = model.nick ?: "",
            avatarUrl = model.avatar_url
        )
    }
}