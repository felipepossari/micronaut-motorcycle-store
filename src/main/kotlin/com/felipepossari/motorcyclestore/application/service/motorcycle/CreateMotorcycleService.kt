package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.adapter.out.repository.MotorcycleRepository
import com.felipepossari.motorcyclestore.application.builder.buildDto
import com.felipepossari.motorcyclestore.application.builder.buildEntity
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.CreateMotorcycleUseCase
import javax.inject.Singleton

@Singleton
class CreateMotorcycleService(private val repository: MotorcycleRepository) : CreateMotorcycleUseCase {
    override fun create(bike: MotorcycleDto): MotorcycleDto {
        val entity = buildEntity(bike)
        val newEntity = repository.save(entity)
        return buildDto(newEntity)
    }
}