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
        val lastId = list.map { it.id }.maxByOrNull { it!! } ?: 0
        val entity = buildEntity(motorcycleDto, lastId + 1)
        list.add(entity)
        return buildDto(entity)
    }

    override fun update(motorcycleDto: MotorcycleDto): MotorcycleDto {
        list.filter { it.id == motorcycleDto.id }.firstOrNull()?.let {
            val updatedBike = it.copy(brand = motorcycleDto.brand,
                    model = motorcycleDto.model,
                    cubicCylinder = motorcycleDto.cubicCylinder,
                    manufactureYear = motorcycleDto.manufactureYear,
                    modelYear = motorcycleDto.modelYear,
                    price = motorcycleDto.price)
            list.remove(it)
            list.add(updatedBike)
        } ?: run {
            throw EntityNotFoundException("Entity with id ${motorcycleDto.id} not found")
        }
        return MotorcycleDto()
    }

    override fun readById(id: Long): MotorcycleDto {
        val bike = list.filter { it.id == id }
                .map { buildDto(it) }
                .firstOrNull()
        return bike ?: throw EntityNotFoundException("Entity with id $id not found")
    }

    override fun read(): List<MotorcycleDto> {
        log.info("Retrieving motorcycles from store")
        return buildDtoList(list.sortedBy { it.id })
    }

    override fun delete(id: Long) {
        list.filter { it.id == id }.firstOrNull()?.let {
            list.remove(it)
        } ?: run {
            throw EntityNotFoundException("Entity with id $id not found")
        }
    }

}