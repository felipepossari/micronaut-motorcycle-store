package com.felipepossari.motorcyclestore.application.service.impl

import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import com.felipepossari.motorcyclestore.application.exception.EntityNotFoundException
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.service.MotorcycleService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class MotorcycleServiceImpl : MotorcycleService {

    private val list = mutableListOf<MotorcycleEntity>(
            MotorcycleEntity(1, "Yamaha", "Tenere", 250, 2013, 2013, 1000.0),
            MotorcycleEntity(2, "Honda", "Cg", 150, 1998, 1998, 2000.0),
            MotorcycleEntity(3, "Suzuki", "Intruder", 125, 2010, 2010, 3000.0),
            MotorcycleEntity(4, "Ducati", "999", 999, 2012, 2012, 4000.0),
            MotorcycleEntity(5, "Dafra", "Kansas", 250, 2011, 2011, 2500.0))

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun create(motorcycleDto: MotorcycleDto): MotorcycleDto {
        TODO("Not yet implemented")
    }

    override fun update(motorcycleDto: MotorcycleDto): MotorcycleDto {
        TODO("Not yet implemented")
    }

    override fun readById(id: Long): MotorcycleDto {
        val bike = list.filter { it.id == id }
                .map { buildDto(it) }
                .firstOrNull()
        return bike ?: throw EntityNotFoundException("Entity with id $id not found")
    }

    override fun read(): List<MotorcycleDto> {
        log.info("Retrieving motorcycles from store")
        val a = buildDtoList(list)
        return buildDtoList(list)
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

}