package com.onix.network.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class SingUpEntity(

    @SerializedName("name")
    var name: String = "",

    @SerializedName("email")
    var email: String = "",

    @SerializedName("password")
    var pass: String = ""
)