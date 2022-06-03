package com.onix.internship.di

import com.onix.internship.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single { PreferenceStorage(get()) }
}