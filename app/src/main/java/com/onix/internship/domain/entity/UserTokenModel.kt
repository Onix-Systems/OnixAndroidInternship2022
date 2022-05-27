package com.onix.internship.domain.entity

data class UserTokenModel(
    var token: String,
    var login: String,
    var user: UserModel
)