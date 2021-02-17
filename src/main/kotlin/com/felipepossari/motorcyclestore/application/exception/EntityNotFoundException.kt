package com.felipepossari.motorcyclestore.application.exception

class EntityNotFoundException : BaseException {

    constructor(errorReason: ErrorReason) : super(errorReason)
}