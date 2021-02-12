package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.adapter.out.repository.MotorcycleRepository
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.GetAllMotorcycleUseCase
import com.felipepossari.motorcyclestore.application.builder.buildDto
import javax.inject.Singleton

@Singleton
class GetAllMotorcycleService(private val motorcycleRepository: MotorcycleRepository) : GetAllMotorcycleUseCase {

    override fun execute(): List<MotorcycleDto> {
        return motorcycleRepository.findAll()
                .map { buildDto(it) }
    }

}