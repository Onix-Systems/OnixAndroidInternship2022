package com.onix.network.api

internal object Api {

    internal object Destination {
        const val BASE_URL = "https://onix.com/v1/"
    }

    internal object Header {
        const val REQUIRES_DEVICE = "Client-Device: mobile"
        const val REQUIRES_TIME_ZONE = "Client-Timezone-Name"
    }

    internal object Url {
        const val LOGIN = "auth/login"
        const val SIGN_UP = "auth/signup"
        const val INIT = "auth/init"
        const val CHAT_CHANNELS = "chat-channels"
    }

}