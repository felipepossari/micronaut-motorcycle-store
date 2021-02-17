package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.adapter.out.repository.MotorcycleRepository
import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import com.felipepossari.motorcyclestore.application.exception.EntityNotFoundException
import com.felipepossari.motorcyclestore.application.exception.ErrorReason
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.DeleteMotorcycleUseCase
import javax.inject.Singleton

@Singleton
class DeleteMotorcycleService(
        private val repository: MotorcycleRepository) : DeleteMotorcycleUseCase {

    override fun execute(id: Long) {
        val bike = retrieveMotorcycle(id)
        repository.delete(bike)
    }

    private fun retrieveMotorcycle(id: Long): MotorcycleEntity =
            repository.findById(id).orElseThrow { throw EntityNotFoundException(ErrorReason.MOTORCYCLE_ID_NOT_FOUND) }
}