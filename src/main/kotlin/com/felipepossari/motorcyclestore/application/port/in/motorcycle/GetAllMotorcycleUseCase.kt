package com.felipepossari.motorcyclestore.application.port.`in`.motorcycle

import com.felipepossari.motorcyclestore.application.model.MotorcycleDto

interface GetAllMotorcycleUseCase {

    fun execute(): List<MotorcycleDto>
}