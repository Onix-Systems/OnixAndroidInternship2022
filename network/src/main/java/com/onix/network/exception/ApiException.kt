package com.onix.network.exception

class ApiException : Exception {
    var apiErrorMessage: String? = null
        private set
    var errorCode = -1
        private set

    constructor() : super()
    constructor(message: String?) : super(message) {
        apiErrorMessage = message
    }

    constructor(message: String?, errorCode: Int) : super(message) {
        apiErrorMessage = message
        this.errorCode = errorCode
    }

    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}