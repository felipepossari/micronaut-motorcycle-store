package com.felipepossari.motorcyclestore.adapter.`in`.controller.motorcycle

import com.felipepossari.motorcyclestore.adapter.`in`.controller.motorcycle.model.MotorcycleRequest
import com.felipepossari.motorcyclestore.adapter.`in`.controller.motorcycle.model.MotorcycleResponse
import com.felipepossari.motorcyclestore.application.service.MotorcycleService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
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

    @Post(
            consumes = [MediaType.APPLICATION_JSON],
            produces = [MediaType.APPLICATION_JSON]
    )
    fun post(@Body request: MotorcycleRequest): HttpResponse<MotorcycleResponse>{
        val dto = buildDto(request)
        val response = service.create(dto)
        return HttpResponse.created(buildResponse(response))
    }

    @Delete("/{id}")
    fun delete(@PathVariable id: Long): HttpResponse<MotorcycleResponse>{
        service.delete(id)
        return HttpResponse.noContent()
    }

    @Put("/{id}")
    fun update(@PathVariable id: Long,
               @Body request: MotorcycleRequest): HttpResponse<MotorcycleResponse>{
        val dto = buildDto(request, id)
        val response = service.update(dto)
        return HttpResponse.ok(buildResponse(response))
    }
}