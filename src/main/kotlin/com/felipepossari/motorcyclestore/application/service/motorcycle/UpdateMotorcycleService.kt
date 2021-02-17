package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.adapter.out.repository.MotorcycleRepository
import com.felipepossari.motorcyclestore.application.builder.buildDto
import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import com.felipepossari.motorcyclestore.application.exception.EntityNotFoundException
import com.felipepossari.motorcyclestore.application.exception.ErrorReason.MOTORCYCLE_ID_NOT_FOUND
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.UpdateMotorcycleUseCase
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
class UpdateMotorcycleService(
        private val repository: MotorcycleRepository,
        private val requestValidator: MotorcycleRequestValidator) : UpdateMotorcycleUseCase {

    override fun execute(dto: MotorcycleDto): MotorcycleDto {
        requestValidator.validateUpdateRequest(dto)
        val bike = retrieveMotorcycle(dto.id!!)
        val updatedBike = bike.copy(brand = dto.brand,
                model = dto.model,
                cubicCylinder = dto.cubicCylinder,
                manufactureYear = dto.manufactureYear,
                modelYear = dto.modelYear,
                price = dto.price)
        val updatedEntity = repository.update(updatedBike)
        return buildDto(updatedEntity)
    }

    private fun retrieveMotorcycle(id: Long): MotorcycleEntity =
            repository.findById(id).orElseThrow { throw EntityNotFoundException(MOTORCYCLE_ID_NOT_FOUND) }
}