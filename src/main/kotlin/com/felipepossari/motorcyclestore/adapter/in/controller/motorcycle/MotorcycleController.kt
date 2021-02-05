package com.felipepossari.motorcyclestore.adapter.`in`.controller.motorcycle

import com.felipepossari.motorcyclestore.adapter.`in`.controller.motorcycle.model.MotorcycleResponse
import com.felipepossari.motorcyclestore.application.service.MotorcycleService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/motorcycle")
class MotorcycleController(private val service: MotorcycleService) {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    @Get
    fun getAll(): HttpResponse<List<MotorcycleResponse>> {
        log.info("Getting motorcycles")
        return HttpResponse.ok(buildResponse(service.read()))
    }

    @Get("/{id}")
    fun getById(@PathVariable id: Long): HttpResponse<MotorcycleResponse> {
        log.info("Getting motorcycle by id")
        return HttpResponse.ok(buildResponse(service.readById(id)))
    }
}