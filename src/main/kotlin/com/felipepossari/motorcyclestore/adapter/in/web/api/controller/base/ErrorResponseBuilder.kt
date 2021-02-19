package com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.base

import com.felipepossari.motorcyclestore.application.exception.ErrorReason

fun buildResultError(errors: List<ErrorReason>): ErrorResponse =
        ErrorResponse(errors.map { Error(it.code, it.message) })
