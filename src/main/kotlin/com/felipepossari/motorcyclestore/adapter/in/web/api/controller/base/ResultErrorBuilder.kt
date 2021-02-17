package com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.base

import com.felipepossari.motorcyclestore.application.exception.ErrorReason

fun buildResultError(errors: List<ErrorReason>): ResponseError =
        ResponseError(errors.map { Error(it.code, it.message) })
