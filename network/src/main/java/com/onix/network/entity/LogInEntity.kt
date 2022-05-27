package com.onix.network.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class LogInEntity(

    @SerializedName("email")
    var email: String = "",

    @SerializedName("password")
    var pass: String = ""
)