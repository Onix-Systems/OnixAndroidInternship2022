package com.onix.network.response

import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @SerializedName("code")
    val code: Int = 0

    @SerializedName("message")
    val message: String? = null

    @SerializedName("name")
    val name: String? = null

    @SerializedName("status")
    val status: Int = 0
}