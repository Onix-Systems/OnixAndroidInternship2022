package com.onix.internship.di

import com.onix.internship.ui.auth.AuthViewModel
import com.onix.internship.ui.chat.ChatViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get(), get()) }
    viewModel { MainViewModel(get()) }
    viewModel { AuthViewModel(get(), get()) }
    viewModel { ChatViewModel(get()) }
}