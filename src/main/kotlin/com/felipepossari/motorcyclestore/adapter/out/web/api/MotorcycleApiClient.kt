package com.felipepossari.motorcyclestore.adapter.out.web.api

import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleRequest
import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.client.annotation.Client

@Client("/motorcycle")
interface MotorcycleApiClient {

    @Get
    fun getAll(@Header("Authorization") authorization: String): HttpResponse<List<MotorcycleResponse>>

    @Get("/{id}")
    fun getById(@Header authorization: String,
                @PathVariable id: Long): HttpResponse<MotorcycleResponse>

    @Post(
            consumes = [MediaType.APPLICATION_JSON],
            produces = [MediaType.APPLICATION_JSON]
    )
    fun post(@Header authorization: String,
             @Body request: MotorcycleRequest): HttpResponse<MotorcycleResponse>

    @Delete("/{id}")
    fun delete(@Header authorization: String,
               @PathVariable id: Long): HttpResponse<MotorcycleResponse>

    @Put("/{id}")
    fun update(@Header authorization: String,
               @PathVariable id: Long,
               @Body request: MotorcycleRequest): HttpResponse<MotorcycleResponse>
}