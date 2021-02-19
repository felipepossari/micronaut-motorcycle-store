package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.application.builder.buildDto
import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import com.felipepossari.motorcyclestore.application.exception.EntityNotFoundException
import com.felipepossari.motorcyclestore.application.exception.ErrorReason.MOTORCYCLE_ID_NOT_FOUND
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.GetMotorcycleByIdUseCase
import com.felipepossari.motorcyclestore.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class GetMotorcycleByIdService(
        private val repositoryPort: MotorcycleRepositoryPort) : GetMotorcycleByIdUseCase {

    override fun execute(id: Long): MotorcycleDto =
            buildDto(retrieveMotorcycle(id))

    private fun retrieveMotorcycle(id: Long): MotorcycleEntity =
            repositoryPort.findById(id) ?: throw EntityNotFoundException(MOTORCYCLE_ID_NOT_FOUND)
}