package com.onix.internship.domain.entity

import com.onix.internship.arch.adapter.AdapterContentElement

class ChannelModel(
    val channelId: Int,
    val idProject: Int,
    val idPartner: Int,
    val userName: String,
    val imageUrl: String?,
    val lastMessage: LastMessageModel,
    val isRead: Boolean,
    val pinToTop: Boolean,
    val userOnline: Boolean = true
) : AdapterContentElement {

    override fun areContentsTheSame(other: AdapterContentElement): Boolean {
        if (other !is ChannelModel) return false

        return channelId == other.channelId
                && idProject == other.idProject
                && idPartner == other.idPartner
                && userName == other.userName
                && lastMessage.areContentsTheSame(other.lastMessage)
                && isRead == other.isRead
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChannelModel
        if (channelId != other.channelId || idProject != other.idProject) return false

        return true
    }

    override fun hashCode(): Int = channelId.hashCode() + idProject.hashCode()

}

class LastMessageModel(
    val id: Int,
    val userId: Int,
    val userName: String,
    val dateCreate: String,
    val isRead: Boolean,
    val text: String
) : AdapterContentElement {

    override fun areContentsTheSame(other: AdapterContentElement): Boolean {
        if (other !is LastMessageModel) return false

        return id == other.id
                && userId == other.userId
                && userName == other.userName
                && dateCreate == other.dateCreate
                && isRead == other.isRead
                && text == other.text
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LastMessageModel
        if (id != other.id || userId != other.userId) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode() + userId.hashCode()
}