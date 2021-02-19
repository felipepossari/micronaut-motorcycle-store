package com.felipepossari.motorcyclestore.adapter.out.repository

import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import com.felipepossari.motorcyclestore.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class MotorcycleRepositoryPortImpl(private val repository: MotorcycleRepository) : MotorcycleRepositoryPort {
    override fun save(motorcycleEntity: MotorcycleEntity): MotorcycleEntity {
        return repository.save(motorcycleEntity)
    }

    override fun update(motorcycleEntity: MotorcycleEntity): MotorcycleEntity {
        return repository.update(motorcycleEntity)
    }

    override fun delete(motorcycleEntity: MotorcycleEntity) {
        repository.delete(motorcycleEntity)
    }

    override fun findById(id: Long): MotorcycleEntity? {
        val entity = repository.findById(id)
        if (entity.isPresent) {
            return entity.get()
        }
        return null
    }

    override fun findAll(): Iterable<MotorcycleEntity> {
        return repository.findAll()
    }
}