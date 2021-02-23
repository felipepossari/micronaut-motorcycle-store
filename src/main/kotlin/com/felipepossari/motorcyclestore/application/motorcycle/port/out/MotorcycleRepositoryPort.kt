package com.felipepossari.motorcyclestore.application.motorcycle.port.out

import com.felipepossari.motorcyclestore.adapter.out.repository.entity.MotorcycleEntity

interface MotorcycleRepositoryPort {

    fun save(motorcycleEntity: MotorcycleEntity): MotorcycleEntity
    fun update(motorcycleEntity: MotorcycleEntity): MotorcycleEntity
    fun delete(motorcycleEntity: MotorcycleEntity)
    fun findById(id: Long): MotorcycleEntity?
    fun findAll(): Iterable<MotorcycleEntity>
}