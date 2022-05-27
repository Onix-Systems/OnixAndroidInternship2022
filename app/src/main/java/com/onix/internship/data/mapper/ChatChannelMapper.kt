package com.onix.internship.data.mapper

import com.onix.network.entity.Channel
import com.onix.network.entity.ChatChannelEntity
import com.onix.internship.arch.mapper.Mapper
import com.onix.internship.domain.entity.ChannelModel
import com.onix.internship.domain.entity.ChatChannelModel
import com.onix.internship.domain.entity.LastMessageModel
import com.onix.internship.domain.entity.UserModel

class ChatChannelMapper : Mapper<ChatChannelEntity, ChatChannelModel> {

    var currentUser: UserModel? = null

    override fun toDomain(model: ChatChannelEntity): ChatChannelModel {
        val channels = mutableListOf<ChannelModel>()

        model.channels?.let { channelList ->
            channelList.forEach { channel ->
                val message = LastMessageModel(
                    id = channel?.message_last?.id ?: 0,
                    userId = channel?.message_last?.id_user ?: 0,
                    userName = channel?.message_last?.user?.name ?: "",
                    dateCreate = channel?.message_last?.dta_create ?: "",
                    isRead = channel?.message_last?.is_read == 0,
                    text = channel?.message_last?.text ?: ""
                )

                val newChannel = ChannelModel(
                    channelId = channel?.id ?: 0,
                    idProject = channel?.id_project ?: 0,
                    idPartner = channel?.id_partner ?: 0,
                    userName = getUserName(channel),
                    imageUrl = getUserAvatar(channel),
                    lastMessage = message,
                    isRead = channel?.message_last?.is_read == 1,
                    pinToTop = channel?.pin_to_top ?: false
                )
                channels.add(newChannel)
            }
        }

        return ChatChannelModel(channels)
    }

    private fun getUserName(channel: Channel?): String {
        return when (channel?.type) {
            MainChannel -> "Main"
            ProjectChannel -> ""
            PmChannel -> currentUser?.name ?: ""
            else -> "Unknown name"
        }
    }

    private fun getUserAvatar(channel: Channel?): String? {
        return when (channel?.type) {
            MainChannel -> channel.message_last?.user?.avatar_url ?: ""
            ProjectChannel -> ""
            PmChannel -> currentUser?.avatarUrl ?: ""
            else -> null
        }
    }

    companion object {
        const val MainChannel = "main"
        const val ProjectChannel = "project"
        const val PmChannel = "pm"
    }

}