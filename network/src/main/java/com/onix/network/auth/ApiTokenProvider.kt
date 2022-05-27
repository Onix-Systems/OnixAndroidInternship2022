package com.onix.network.auth

interface ApiTokenProvider {

    fun saveToken(userToken: String, login: String)

    fun getToken(): String

    fun getLogin(): String

    fun hasToken(): Boolean

    fun clear()
}