package com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle

import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleRequest
import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleResponse
import com.felipepossari.motorcyclestore.adapter.`in`.web.api.MotorcycleApi
import com.felipepossari.motorcyclestore.application.service.MotorcycleService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/motorcycle")
class MotorcycleController(private val service: MotorcycleService) : MotorcycleApi {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun getAll(): HttpResponse<List<MotorcycleResponse>> {
        log.info("Getting motorcycles")
        return HttpResponse.ok(buildResponse(service.read()))
    }

    override fun getById(id: Long): HttpResponse<MotorcycleResponse> {
        log.info("Getting motorcycle by id")
        return HttpResponse.ok(buildResponse(service.readById(id)))
    }

    @Secured("admin")
    override fun post(request: MotorcycleRequest): HttpResponse<MotorcycleResponse> {
        val dto = buildDto(request)
        val response = service.create(dto)
        return HttpResponse.created(buildResponse(response))
    }

    @Secured("admin")
    override fun delete(id: Long): HttpResponse<MotorcycleResponse> {
        service.delete(id)
        return HttpResponse.noContent()
    }

    @Secured("admin")
    override fun update(id: Long,
                        request: MotorcycleRequest): HttpResponse<MotorcycleResponse> {
        val dto = buildDto(request, id)
        val response = service.update(dto)
        return HttpResponse.ok(buildResponse(response))
    }
}