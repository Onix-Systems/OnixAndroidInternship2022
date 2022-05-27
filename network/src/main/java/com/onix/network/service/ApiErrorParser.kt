package com.onix.network.service

import com.google.gson.Gson
import com.onix.network.exception.ApiException
import com.onix.network.exception.SignUpException
import com.onix.network.response.ErrorResponse
import com.onix.network.response.ErrorSignUpResponse
import retrofit2.Response

class ApiErrorParser(private val gson: Gson) {

    fun extractError(apiResponse: Response<*>, defaultError: String? = null): Exception {
        return try {
            if (apiResponse.errorBody() == null) {
                return if (defaultError == null) ApiException() else ApiException(defaultError)
            }

            val errorBody = apiResponse.errorBody()
            val rawResponse = errorBody!!.string()
            try {
                val errorResponse = gson.fromJson(rawResponse, ErrorResponse::class.java)
                errorResponse.message?.let {
                    return ApiException(errorResponse.message)
                }
            } catch (e: Throwable) {
                e.printStackTrace()
            }

            val errSignUp = gson.fromJson(rawResponse, ErrorSignUpResponse::class.java)
            SignUpException(errSignUp.first_errors?.email)
        } catch (error: Throwable) {
            ApiException(error)
        }
    }
}