package com.onix.internship.domain.usecase

import com.onix.network.response.Either
import com.onix.internship.data.repository.ChatChannelsRepository
import com.onix.internship.domain.entity.ChatChannelModel
import com.onix.internship.domain.entity.UserModel

class ChatChannelsUseCase(private val channelsRepository: ChatChannelsRepository) {

    suspend fun loadChatChannels(user: UserModel): Either<ChatChannelModel> {
        return try {
            channelsRepository.loadChatChannels(user)
        } catch (e: Throwable) {
            Either.failure(e)
        }
    }

}