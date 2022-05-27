package com.onix.network.service

import com.onix.network.api.Api.Header.REQUIRES_DEVICE
import com.onix.network.api.Api.Url.CHAT_CHANNELS
import com.onix.network.api.Api.Url.INIT
import com.onix.network.api.Api.Url.LOGIN
import com.onix.network.api.Api.Url.SIGN_UP
import com.onix.network.entity.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST(LOGIN)
    @Headers(REQUIRES_DEVICE)
    suspend fun logIn(@Body loginRequest: LogInEntity): Response<UserToken>

    @POST(SIGN_UP)
    @Headers(REQUIRES_DEVICE)
    suspend fun signUp(@Body loginRequest: SingUpEntity): Response<UserToken>

    @GET(INIT)
    @Headers(REQUIRES_DEVICE)
    suspend fun initUser(): Response<CurrentUser>

    @GET(CHAT_CHANNELS)
    @Headers(REQUIRES_DEVICE)
    suspend fun loadChatChannels(): Response<ChatChannelEntity>

}