package com.felipepossari.motorcyclestore.adapter.`in`.controller.motorcycle.model

import io.micronaut.http.HttpStatus

data class ResultError(val status: HttpStatus, val message: String)