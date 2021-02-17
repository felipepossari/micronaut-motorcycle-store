package com.felipepossari.motorcyclestore.application.exception

class InvalidArgumentException : BaseException {

    constructor(errorReason: ErrorReason) : super(errorReason)

    constructor(errorsReasons: List<ErrorReason>) : super(errorsReasons)
}