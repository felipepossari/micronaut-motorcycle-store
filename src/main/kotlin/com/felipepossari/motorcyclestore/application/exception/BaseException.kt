package com.felipepossari.motorcyclestore.application.exception

open class BaseException : Exception {
    var errors: MutableList<ErrorReason> = mutableListOf()
        private set

    constructor(errorReason: ErrorReason) {
        errors.add(errorReason)
    }

    constructor(errorsReasons: List<ErrorReason>) {
        errors = errorsReasons as MutableList<ErrorReason>
    }
}