package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.application.builder.buildDto
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.`in`.motorcycle.GetAllMotorcycleUseCase
import com.felipepossari.motorcyclestore.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class GetAllMotorcycleService(private val repositoryPort: MotorcycleRepositoryPort) : GetAllMotorcycleUseCase {

    override fun execute(): List<MotorcycleDto> {
        return repositoryPort.findAll()
                .map { buildDto(it) }
    }

}