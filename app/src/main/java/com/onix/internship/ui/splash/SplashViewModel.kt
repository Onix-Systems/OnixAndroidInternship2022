package com.onix.internship.ui.splash

import com.onix.network.auth.ApiTokenProvider
import com.onix.network.response.onFailure
import com.onix.network.response.onSuccess
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.domain.entity.UserModel
import com.onix.internship.domain.usecase.InitUserUseCase

class SplashViewModel(
    private val tokenProvider: ApiTokenProvider,
    private val initUserUseCase: InitUserUseCase
) : BaseViewModel() {

    val initEvent = SingleLiveEvent<Boolean>()
    var user: UserModel? = null

    fun hasToken() = tokenProvider.hasToken()

    fun init() {
        onLoading(true)
        launch {
            initUserUseCase.initUser(tokenProvider.getToken())
                .onSuccess {
                    user = it
                    onLoading(false)
                    initEvent.postValue(true)
                }
                .onFailure {
                    onLoading(false)
                    showMsgError(it.message)
                    initEvent.postValue(false)
                }
        }
    }
}