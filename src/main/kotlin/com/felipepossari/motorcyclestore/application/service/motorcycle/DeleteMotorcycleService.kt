package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import com.felipepossari.motorcyclestore.application.exception.EntityNotFoundException
import com.felipepossari.motorcyclestore.application.exception.ErrorReason
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.DeleteMotorcycleUseCase
import com.felipepossari.motorcyclestore.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class DeleteMotorcycleService(
        private val repositoryPort: MotorcycleRepositoryPort) : DeleteMotorcycleUseCase {

    override fun execute(id: Long) {
        val bike = retrieveMotorcycle(id)
        repositoryPort.delete(bike)
    }

    private fun retrieveMotorcycle(id: Long): MotorcycleEntity =
            repositoryPort.findById(id) ?: throw EntityNotFoundException(ErrorReason.MOTORCYCLE_ID_NOT_FOUND)
}