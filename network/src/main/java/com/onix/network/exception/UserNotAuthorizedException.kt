package com.onix.network.exception

import java.io.IOException

class UserNotAuthorizedException : IOException {

    constructor() : super()

    constructor(message: String?) : super(message)

    constructor(message: String?, cause: Throwable?) : super(message, cause)

    constructor(cause: Throwable?) : super(cause)
}