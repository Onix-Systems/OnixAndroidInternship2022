package com.onix.internship.domain.provider

import com.onix.network.auth.ApiTokenProvider
import com.onix.internship.data.repository.PreferenceStorage

private const val PREFS_TOKEN = "PREFS_TOKEN"
private const val PREFS_LOGIN = "PREFS_LOGIN"

class TokenProvider(private val preferenceStorage: PreferenceStorage) : ApiTokenProvider {

    override fun hasToken(): Boolean = getToken().isNotEmpty()

    override fun saveToken(userToken: String, login: String) {
        preferenceStorage.save(PREFS_TOKEN, userToken)
        preferenceStorage.save(PREFS_LOGIN, login)
    }

    override fun getToken(): String {
        return preferenceStorage.getString(PREFS_TOKEN, "") ?: ""
    }

    override fun getLogin(): String {
        return preferenceStorage.getString(PREFS_LOGIN, "") ?: ""
    }

    override fun clear() {
        preferenceStorage.save(PREFS_TOKEN, "")
    }
}