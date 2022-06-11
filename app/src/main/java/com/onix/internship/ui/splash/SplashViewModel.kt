package com.onix.internship.ui.splash

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import kotlinx.coroutines.delay

class SplashViewModel(

) : BaseViewModel() {

    val initEvent = SingleLiveEvent<Boolean>()

    init {
        onLoading(true)
        launch {
            delay(1000)
            initEvent.postValue(true)
        }
    }

}