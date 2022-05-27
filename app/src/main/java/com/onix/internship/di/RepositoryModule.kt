package com.onix.internship.di

import com.onix.network.auth.ApiTokenProvider
import com.onix.internship.data.repository.*
import com.onix.internship.domain.provider.TokenProvider
import org.koin.dsl.module

val repositoryModule = module {
    single { PreferenceStorage(get()) }
    single { TokenProvider(get()) }
    single<ApiTokenProvider> { get<TokenProvider>() }
    single<AuthRepository> { AuthRepositoryImpl(get(), get(), get()) }
    single<ChatChannelsRepository> { ChatChannelsRepositoryImpl(get(), get()) }
}