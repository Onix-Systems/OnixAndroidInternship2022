package com.onix.internship.arch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val loading = MutableLiveData(false)
    val errorEvent = SingleLiveEvent<String>()

    protected fun showMsgError(msg: String?) {
        msg?.let { errorEvent.postValue(it) }
    }

    protected fun launch(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(block = block)

    protected fun onLoading(state: Boolean) {
        loading.postValue(state)
    }

}