package com.onix.internship.di

import com.onix.internship.ui.auth.AuthViewModel
import com.onix.internship.ui.canvas.CanvasViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CanvasViewModel() }
    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
    viewModel { AuthViewModel(get()) }

}