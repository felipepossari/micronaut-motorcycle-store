package com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle

import com.felipepossari.motorcyclestore.adapter.`in`.web.api.MotorcycleApi
import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleRequest
import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleResponse
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.CreateMotorcycleUseCase
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.DeleteMotorcycleUseCase
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.GetAllMotorcycleUseCase
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.GetMotorcycleByIdUseCase
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.UpdateMotorcycleUseCase
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/motorcycle")
class MotorcycleController(
        private val getAllUseCase: GetAllMotorcycleUseCase,
        private val createUseCase: CreateMotorcycleUseCase,
        private val getByIdUseCase: GetMotorcycleByIdUseCase,
        private val deleteUseCase: DeleteMotorcycleUseCase,
        private val updateUseCase: UpdateMotorcycleUseCase) : MotorcycleApi {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun getAll(): HttpResponse<List<MotorcycleResponse>> {
        log.info("Getting motorcycles")
        return HttpResponse.ok(buildResponse(getAllUseCase.execute()))
    }

    override fun getById(id: Long): HttpResponse<MotorcycleResponse> {
        log.info("Getting motorcycle by id")
        return HttpResponse.ok(buildResponse(getByIdUseCase.execute(id)))
    }

    @Secured("admin")
    override fun post(request: MotorcycleRequest): HttpResponse<MotorcycleResponse> {
        val response = createUseCase.create(buildDto(request))
        return HttpResponse.created(buildResponse(response))
    }

    @Secured("admin")
    override fun delete(id: Long): HttpResponse<MotorcycleResponse> {
        deleteUseCase.execute(id)
        return HttpResponse.noContent()
    }

    @Secured("admin")
    override fun update(id: Long,
                        request: MotorcycleRequest): HttpResponse<MotorcycleResponse> {
        val dto = buildDto(request, id)
        val updatedDto = updateUseCase.execute(dto)
        return HttpResponse.ok(buildResponse(updatedDto))
    }
}