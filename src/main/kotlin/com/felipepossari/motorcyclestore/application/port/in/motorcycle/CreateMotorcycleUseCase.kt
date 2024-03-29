package com.felipepossari.motorcyclestore.application.port.`in`.motorcycle

import com.felipepossari.motorcyclestore.application.model.MotorcycleDto

interface CreateMotorcycleUseCase {

    fun create(dto: MotorcycleDto): MotorcycleDto
}