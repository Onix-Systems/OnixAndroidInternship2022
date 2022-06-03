package com.onix.internship.ui.auth


import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.domain.entity.UserModel
import com.onix.internship.domain.usecase.AuthUseCase

class AuthViewModel(
    private val authUseCase: AuthUseCase,
) : BaseViewModel() {

    var userName: String = ""
    var emailAddress: String = ""
    var pass: String = ""

    val logInEvent = SingleLiveEvent<UserModel>()

    init {

    }

    fun signUp() {
        onLoading(true)
    }

}