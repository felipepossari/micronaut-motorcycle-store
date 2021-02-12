package com.felipepossari.motorcyclestore.application.builder

import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto

fun buildDto(entity: MotorcycleEntity) =
        MotorcycleDto(
                id = entity.id,
                brand = entity.brand,
                model = entity.model,
                cubicCylinder = entity.cubicCylinder,
                manufactureYear = entity.manufactureYear,
                modelYear = entity.modelYear,
                price = entity.price
        )

fun buildEntity(dto: MotorcycleDto) =
        MotorcycleEntity(
                brand = dto.brand,
                model = dto.model,
                cubicCylinder = dto.cubicCylinder,
                manufactureYear = dto.manufactureYear,
                modelYear = dto.modelYear,
                price = dto.price
        )

fun buildEntity(dto: MotorcycleDto, id: Long) =
        MotorcycleEntity(
                id = id,
                brand = dto.brand,
                model = dto.model,
                cubicCylinder = dto.cubicCylinder,
                manufactureYear = dto.manufactureYear,
                modelYear = dto.modelYear,
                price = dto.price
        )

fun buildDtoList(entities: List<MotorcycleEntity>): List<MotorcycleDto> =
        entities.map {
            buildDto(it)
        }
