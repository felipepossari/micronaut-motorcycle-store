package com.felipepossari.motorcyclestore.application.port.`in`.motorcycle

import com.felipepossari.motorcyclestore.application.model.MotorcycleDto

interface GetMotorcycleByIdUseCase {

    fun execute(id: Long): MotorcycleDto
}