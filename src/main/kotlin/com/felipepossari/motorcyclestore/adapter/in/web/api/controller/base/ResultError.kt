package com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.base

import io.micronaut.http.HttpStatus

data class ResultError(val status: HttpStatus, val message: String)