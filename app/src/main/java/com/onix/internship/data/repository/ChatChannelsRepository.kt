package com.onix.internship.data.repository

import com.onix.network.response.Either
import com.onix.network.response.map
import com.onix.network.service.NetworkService
import com.onix.internship.data.mapper.ChatChannelMapper
import com.onix.internship.domain.entity.ChatChannelModel
import com.onix.internship.domain.entity.UserModel

interface ChatChannelsRepository {
    suspend fun loadChatChannels(user: UserModel): Either<ChatChannelModel>
}

class ChatChannelsRepositoryImpl(
    private val networkService: NetworkService,
    private val channelMapper: ChatChannelMapper
) : ChatChannelsRepository {

    override suspend fun loadChatChannels(user: UserModel): Either<ChatChannelModel> {
        return try {
            networkService.loadChatList().map {
                channelMapper.currentUser = user
                channelMapper.toDomain(it)
            }
        } catch (e: Throwable) {
            Either.failure(e)
        }
    }

}
