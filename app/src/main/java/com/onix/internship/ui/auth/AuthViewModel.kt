package com.onix.internship.ui.auth

import com.onix.network.auth.ApiTokenProvider
import com.onix.network.response.onFailure
import com.onix.network.response.onSuccess
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.domain.entity.UserModel
import com.onix.internship.domain.usecase.AuthUseCase

class AuthViewModel(
    private val authUseCase: AuthUseCase,
    private val tokenProvider: ApiTokenProvider
) : BaseViewModel() {

    var userName: String = ""
    var emailAddress: String = ""
    var pass: String = ""

    val logInEvent = SingleLiveEvent<UserModel>()

    init {
        if (tokenProvider.hasToken()) {
            userName = tokenProvider.getLogin()
        }
    }

    fun signUp() {
        onLoading(true)
        launch {
            authUseCase.signUp(userName, emailAddress, pass)
                .onSuccess {
                    tokenProvider.saveToken(it.token, it.login)
                    logInEvent.postValue(it.user)
                    onLoading(false)
                }
                .onFailure {
                    showMsgError(it.message)
                    onLoading(false)
                }
        }
    }

}