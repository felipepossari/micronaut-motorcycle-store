package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.application.builder.buildDto
import com.felipepossari.motorcyclestore.application.builder.buildEntity
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.CreateMotorcycleUseCase
import com.felipepossari.motorcyclestore.application.port.out.MotorcycleRepositoryPort
import com.felipepossari.motorcyclestore.application.port.out.StockAmountPublisherPort
import javax.inject.Singleton

@Singleton
class CreateMotorcycleService(
        private val repositoryPort: MotorcycleRepositoryPort,
        private val requestValidator: MotorcycleRequestValidator,
        private val stockAmountPublisherPort: StockAmountPublisherPort) : CreateMotorcycleUseCase {
    override fun create(dto: MotorcycleDto): MotorcycleDto {
        requestValidator.validateCreateRequest(dto)
        val entity = buildEntity(dto)
        val newEntity = repositoryPort.save(entity)
        stockAmountPublisherPort.publishIncreaseStockMessage(dto)
        return buildDto(newEntity)
    }
}