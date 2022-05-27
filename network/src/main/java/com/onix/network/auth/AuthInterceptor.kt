package com.onix.network.auth

import com.onix.network.api.Api.Header.REQUIRES_TIME_ZONE
import com.onix.network.exception.UserNotAuthorizedException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

private const val UNAUTHORIZED_HTTP_CODE = 401

internal class AuthInterceptor(private val apiTokenProvider: ApiTokenProvider) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val decorateRequest = chain.request()
            .newBuilder()
            .addHeader(REQUIRES_TIME_ZONE, "Europe/Kiev")

        if (apiTokenProvider.hasToken()) {
            decorateRequest.addHeader("Authorization", "Bearer ${apiTokenProvider.getToken()}")
        }

        val authorizedResponse = chain.proceed(decorateRequest.build())

        if (authorizedResponse.code == UNAUTHORIZED_HTTP_CODE) {
            throw UserNotAuthorizedException()
        }

        return authorizedResponse
    }
}