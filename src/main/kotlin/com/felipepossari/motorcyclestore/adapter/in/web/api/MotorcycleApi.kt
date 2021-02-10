package com.felipepossari.motorcyclestore.adapter.`in`.web.api

import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleRequest
import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.security.annotation.Secured


interface MotorcycleApi {

    @Get
    fun getAll(): HttpResponse<List<MotorcycleResponse>>

    @Get("/{id}")
    fun getById(@PathVariable id: Long): HttpResponse<MotorcycleResponse>

    @Secured("admin")
    @Post(
            consumes = [MediaType.APPLICATION_JSON],
            produces = [MediaType.APPLICATION_JSON]
    )
    fun post(@Body request: MotorcycleRequest): HttpResponse<MotorcycleResponse>

    @Secured("admin")
    @Delete("/{id}")
    fun delete(@PathVariable id: Long): HttpResponse<MotorcycleResponse>

    @Secured("admin")
    @Put("/{id}")
    fun update(@PathVariable id: Long,
               @Body request: MotorcycleRequest): HttpResponse<MotorcycleResponse>

}