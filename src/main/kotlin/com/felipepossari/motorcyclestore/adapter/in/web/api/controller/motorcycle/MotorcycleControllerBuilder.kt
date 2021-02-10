package com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle

import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleRequest
import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleResponse
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto

fun buildDto(request: MotorcycleRequest) =
        MotorcycleDto(
                brand = request.brand,
                model = request.model,
                cubicCylinder = request.cubicCylinder,
                manufactureYear = request.manufactureYear,
                modelYear = request.modelYear,
                price = request.price
        )

fun buildDto(request: MotorcycleRequest, id: Long) =
        MotorcycleDto(
                id = id,
                brand = request.brand,
                model = request.model,
                cubicCylinder = request.cubicCylinder,
                manufactureYear = request.manufactureYear,
                modelYear = request.modelYear,
                price = request.price
        )

fun buildResponse(dto: MotorcycleDto) =
        MotorcycleResponse(
                id = dto.id,
                brand = dto.brand,
                model = dto.model,
                cubicCylinder = dto.cubicCylinder,
                manufactureYear = dto.manufactureYear,
                modelYear = dto.modelYear,
                price = dto.price
        )

fun buildResponse(dtos: List<MotorcycleDto>) =
        dtos.map {
            buildResponse(it)
        }