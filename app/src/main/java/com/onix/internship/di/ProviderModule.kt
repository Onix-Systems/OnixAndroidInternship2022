package com.onix.internship.di

import com.onix.internship.arch.provider.TextResProvider
import com.onix.internship.domain.usecase.AuthUseCase
import com.onix.internship.domain.usecase.ChatChannelsUseCase
import com.onix.internship.domain.usecase.InitUserUseCase
import org.koin.dsl.module

val providerModule = module {
    single { TextResProvider(get()) }
    single { AuthUseCase(get(), get()) }
    single { InitUserUseCase(get(), get()) }
    single { ChatChannelsUseCase(get()) }
}