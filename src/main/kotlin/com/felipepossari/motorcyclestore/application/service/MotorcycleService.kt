package com.felipepossari.motorcyclestore.application.service

import com.felipepossari.motorcyclestore.application.model.MotorcycleDto

interface MotorcycleService {

    fun create(motorcycleDto: MotorcycleDto): MotorcycleDto
    fun update(motorcycleDto: MotorcycleDto): MotorcycleDto
    fun readById(id: Long): MotorcycleDto
    fun read(): List<MotorcycleDto>
    fun delete(id: Long)
}