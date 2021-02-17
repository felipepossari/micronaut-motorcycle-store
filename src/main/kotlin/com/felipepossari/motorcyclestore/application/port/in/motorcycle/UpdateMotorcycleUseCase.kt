package com.felipepossari.motorcyclestore.application.port.`in`.motorcycle

import com.felipepossari.motorcyclestore.application.model.MotorcycleDto

interface UpdateMotorcycleUseCase {

    fun execute(dto: MotorcycleDto): MotorcycleDto
}