package com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.base

import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.ResultError
import com.felipepossari.motorcyclestore.application.exception.EntityNotFoundException
import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import javax.inject.Singleton

@Produces
@Singleton
@Requirements(
        Requires(classes = [EntityNotFoundException::class, ExceptionHandler::class])
)
class ControllerExceptionHandler : ExceptionHandler<EntityNotFoundException, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>?, exception: EntityNotFoundException): HttpResponse<*> {
        val resultError = ResultError(HttpStatus.NOT_FOUND, exception.message!!)
        return HttpResponse.notFound(resultError)
    }
}
