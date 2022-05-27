package com.onix.internship.ui.chat

import androidx.lifecycle.MutableLiveData
import com.onix.network.response.onFailure
import com.onix.network.response.onSuccess
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.domain.entity.ChatChannelModel
import com.onix.internship.domain.entity.UserModel
import com.onix.internship.domain.usecase.ChatChannelsUseCase

class ChatViewModel(private val chatChannelsUseCase: ChatChannelsUseCase) : BaseViewModel() {

    val chatChannelEvent = MutableLiveData<ChatChannelModel>()
    private var currUser: UserModel? = null

    fun loadChatList(user: UserModel) {
        currUser = user
        onLoading(true)
        launch {
            chatChannelsUseCase.loadChatChannels(user)
                .onSuccess {
                    onLoading(false)
                    chatChannelEvent.postValue(it)
                }
                .onFailure {
                    onLoading(false)
                    showMsgError(it.message)
                }
        }
    }

    fun refreshList() {
        currUser?.let {
            loadChatList(it)
        }
    }
}