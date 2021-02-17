package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.adapter.out.repository.MotorcycleRepository
import com.felipepossari.motorcyclestore.application.builder.buildDto
import com.felipepossari.motorcyclestore.application.builder.buildEntity
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.CreateMotorcycleUseCase
import javax.inject.Singleton

@Singleton
class CreateMotorcycleService(
        private val repository: MotorcycleRepository,
        private val requestValidator: MotorcycleRequestValidator) : CreateMotorcycleUseCase {
    override fun create(dto: MotorcycleDto): MotorcycleDto {
        requestValidator.validateCreateRequest(dto)
        val entity = buildEntity(dto)
        val newEntity = repository.save(entity)
        return buildDto(newEntity)
    }
}