package com.onix.internship.ui.main

import com.onix.network.auth.ApiTokenProvider
import com.onix.internship.arch.BaseViewModel

class MainViewModel(private val tokenProvider: ApiTokenProvider) : BaseViewModel() {

    fun logOut() {
        tokenProvider.clear()
    }
}
