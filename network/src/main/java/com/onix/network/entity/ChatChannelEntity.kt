package com.onix.network.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatChannelEntity(
    @SerialName("channels")
    val channels: List<Channel?>?
)

@Serializable
data class Channel(
    @SerialName("custom_info")
    val custom_info: String?,
    @SerialName("draft")
    val draft: Draft?,
    @SerialName("dta_change_msg")
    val dta_change_msg: String?,
    @SerialName("dta_create")
    val dta_create: String?,
    @SerialName("dta_last_read")
    val dta_last_read: String?,
    @SerialName("dta_pin")
    val dta_pin: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("id_partner")
    val id_partner: Int?,
    @SerialName("id_project")
    val id_project: Int?,
    @SerialName("id_users")
    val id_users: List<Int?>?,
    @SerialName("is_hide_in_chats_list")
    val is_hide_in_chats_list: Boolean?,
    @SerialName("is_mute")
    val is_mute: Boolean?,
    @SerialName("is_starred")
    val is_starred: Boolean?,
    @SerialName("is_unread_manual")
    val is_unread_manual: Boolean?,
    @SerialName("message_last")
    val message_last: MessageLast?,
    @SerialName("mute_until_period")
    val mute_until_period: Int?,
    @SerialName("pin_to_top")
    val pin_to_top: Boolean?,
    @SerialName("type")
    val type: String?
)

@Serializable
data class MessageLast(
    @SerialName("dta_create")
    val dta_create: String?,
    @SerialName("file")
    val file: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("id_channel")
    val id_channel: Int?,
    @SerialName("id_user")
    val id_user: Int?,
    @SerialName("is_edited")
    val is_edited: Boolean?,
    @SerialName("is_read")
    val is_read: Int?,
    @SerialName("is_starred")
    val is_starred: Boolean?,
    @SerialName("reply_on")
    val reply_on: String?,
    @SerialName("snippet")
    val snippet: String?,
    @SerialName("text")
    val text: String?,
    @SerialName("user")
    val user: UserMessage?
)

@Serializable
data class UserMessage(
    @SerialName("avatar_url")
    val avatar_url: String?,
    @SerialName("name")
    val name: String?
)

@Serializable
data class Draft(
    @SerialName("id_reply")
    val id_reply: String?,
    @SerialName("text")
    val text: String?
)