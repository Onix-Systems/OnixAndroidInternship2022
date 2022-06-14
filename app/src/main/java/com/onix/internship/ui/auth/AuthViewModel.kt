package com.onix.internship.ui.auth


import com.onix.internship.arch.BaseViewModel
import com.onix.internship.domain.usecase.AuthUseCase

class AuthViewModel(
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {

    var userName: String = ""
    var emailAddress: String = ""
    var pass: String = ""

    fun signUp() {
        onLoading(true)
    }

}