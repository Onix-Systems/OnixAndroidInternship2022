package com.onix.network.di

import com.onix.network.api.Api
import com.onix.network.api.NetworkProvider
import com.onix.network.auth.AuthInterceptor
import com.onix.network.service.ApiErrorParser
import com.onix.network.service.ApiService
import com.onix.network.service.NetworkService
import org.koin.dsl.module

val networkModule = module {

    single { NetworkProvider.provideGson() }
    single { AuthInterceptor(get()) }
    single { ApiErrorParser(get()) }
    single {
        NetworkProvider.provideApiService(
            get(), get(), Api.Destination.BASE_URL, ApiService::class.java
        )
    }

    single { NetworkService(get(), get()) }
}