package com.onix.internship.di

import com.onix.internship.data.mapper.ChatChannelMapper
import com.onix.internship.data.mapper.TokenMapper
import com.onix.internship.data.mapper.UserMapper
import org.koin.dsl.module

val mapperModule = module {
    single { UserMapper() }
    single { TokenMapper(get()) }
    single { ChatChannelMapper() }
}