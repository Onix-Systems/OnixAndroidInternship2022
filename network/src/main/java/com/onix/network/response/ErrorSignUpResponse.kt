package com.onix.network.response

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorSignUpResponse(
    @SerializedName("first_errors")
    val first_errors: FirstErrors?
)

@Serializable
data class FirstErrors(
    @SerializedName("email")
    val email: String?
)
