package com.felipepossari.motorcyclestore.adapter.out.repository

import com.felipepossari.motorcyclestore.application.entity.MotorcycleEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface MotorcycleRepository : CrudRepository<MotorcycleEntity, Long?> {
}