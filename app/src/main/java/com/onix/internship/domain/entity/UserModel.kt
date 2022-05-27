package com.onix.internship.domain.entity

import java.io.Serializable

data class UserModel(
    val id: Int,
    val name: String,
    val nick: String,
    val avatarUrl: String?,
) : Serializable