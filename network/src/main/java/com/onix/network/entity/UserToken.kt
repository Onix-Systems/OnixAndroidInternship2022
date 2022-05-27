package com.onix.network.entity

import com.onix.network.response.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserToken(
    @SerialName("already_join_project")
    val already_join_project: String?,
    @SerialName("app_init")
    val app_init: AppInit,
    @SerialName("token")
    val token: String
) : BaseResponse()

@Serializable
data class AppInit(
    @SerialName("auth_items")
    val auth_items: AuthItems?,
    @SerialName("chats_count_unread")
    val chats_count_unread: Int?,
    @SerialName("companies")
    val companies: List<Company?>?,
    @SerialName("hidden_projects")
    val hidden_projects: List<String?>?,
    @SerialName("user")
    val user: User?,
    @SerialName("user_settings")
    val user_settings: UserSettings?,
    @SerialName("user_settings_global")
    val user_settings_global: UserSettingsGlobal?
)

@Serializable
data class AuthItems(
    @SerialName("can_edit_time")
    val can_edit_time: Boolean?,
    @SerialName("chat")
    val chat: Boolean?,
    @SerialName("coder")
    val coder: Boolean?,
    @SerialName("disc_space")
    val disc_space: Boolean?,
    @SerialName("instant_screen")
    val instant_screen: Boolean?,
    @SerialName("member_area")
    val member_area: Boolean?,
    @SerialName("owner")
    val owner: Boolean?,
    @SerialName("screens_month")
    val screens_month: Boolean?,
    @SerialName("timelapse_video")
    val timelapse_video: Boolean?,
    @SerialName("tracked_timer_month")
    val tracked_timer_month: Boolean?,
    @SerialName("trial")
    val trial: Boolean?
)

@Serializable
data class Company(
    @SerialName("dta_create")
    val dta_create: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("id_user")
    val id_user: Int?,
    @SerialName("is_my")
    val is_my: Boolean?,
    @SerialName("is_plan_almost_used")
    val is_plan_almost_used: Boolean?,
    @SerialName("logo_url")
    val logo_url: String?,
    @SerialName("max_file_count")
    val max_file_count: Int?,
    @SerialName("max_file_size")
    val max_file_size: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("owner_fullname")
    val owner_fullname: String?,
    @SerialName("screens_interval")
    val screens_interval: Int?,
    @SerialName("screens_quality")
    val screens_quality: Int?,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("timezone_offset")
    val timezone_offset: Int?,
    @SerialName("uid")
    val uid: String?,
    @SerialName("updated")
    val updated: Int?
)

@Serializable
data class User(
    @SerialName("avatar_url")
    val avatar_url: String?,
    @SerialName("dta_activity")
    val dta_activity: String?,
    @SerialName("dta_create")
    val dta_create: String?,
    @SerialName("dta_timer_activity")
    val dta_timer_activity: String?,
    @SerialName("due_penalties")
    val due_penalties: Int?,
    @SerialName("email")
    val email: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("id_company")
    val id_company: Int?,
    @SerialName("is_active")
    val is_active: Boolean?,
    @SerialName("is_chat_email_notification")
    val is_chat_email_notification: Boolean?,
    @SerialName("is_online")
    val is_online: Int?,
    @SerialName("is_shared_from_me")
    val is_shared_from_me: Boolean?,
    @SerialName("is_telegram_connected")
    val is_telegram_connected: Boolean?,
    @SerialName("is_timer_online")
    val is_timer_online: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("nick")
    val nick: String?,
    @SerialName("projects")
    val projects: List<String?>?,
    @SerialName("role")
    val role: String?,
    @SerialName("telegram_connect_url")
    val telegram_connect_url: String?,
    @SerialName("timer_last")
    val timer_last: String?,
    @SerialName("timezone_offset")
    val timezone_offset: Int?
)

@Serializable
data class UserSettings(
    @SerialName("cache_updated")
    val cache_updated: Boolean?,
    @SerialName("client_settings")
    val client_settings: String?,
    @SerialName("dta_mute_until")
    val dta_mute_until: String?,
    @SerialName("is_mute_chats")
    val is_mute_chats: Boolean?,
    @SerialName("lang")
    val lang: String?,
    @SerialName("mute_until_period")
    val mute_until_period: Int?
)

@Serializable
data class UserSettingsGlobal(
    @SerialName("client_settings")
    val client_settings: String?,
    @SerialName("is_chat_email_notification")
    val is_chat_email_notification: Boolean
)

@Serializable
data class CurrentUser(
    @SerialName("user")
    val user: User?
)