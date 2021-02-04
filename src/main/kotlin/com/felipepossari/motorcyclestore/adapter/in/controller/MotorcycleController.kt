package com.felipepossari.motorcyclestore.adapter.`in`.controller

import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.service.MotorcycleService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/motorcycle")
class MotorcycleController(private val service: MotorcycleService) {

    companion object{
        private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    @Get
    fun getAll(): List<MotorcycleDto>{
        log.info("Getting motorcycles")
        return service.read()
    }
}