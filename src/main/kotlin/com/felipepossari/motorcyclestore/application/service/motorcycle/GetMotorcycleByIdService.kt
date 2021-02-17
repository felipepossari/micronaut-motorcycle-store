package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.adapter.out.repository.MotorcycleRepository
import com.felipepossari.motorcyclestore.application.builder.buildDto
import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import com.felipepossari.motorcyclestore.application.exception.EntityNotFoundException
import com.felipepossari.motorcyclestore.application.exception.ErrorReason
import com.felipepossari.motorcyclestore.application.exception.ErrorReason.MOTORCYCLE_ID_NOT_FOUND
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.GetMotorcycleByIdUseCase
import javax.inject.Singleton

@Singleton
class GetMotorcycleByIdService(
        private val repository: MotorcycleRepository) : GetMotorcycleByIdUseCase {

    override fun execute(id: Long): MotorcycleDto =
            buildDto(retrieveMotorcycle(id))

    private fun retrieveMotorcycle(id: Long): MotorcycleEntity =
            repository.findById(id).orElseThrow { throw EntityNotFoundException(MOTORCYCLE_ID_NOT_FOUND) }
}