package com.felipepossari.motorcyclestore.adapter.out.repository

import com.felipepossari.motorcyclestore.application.entity.UserEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long?> {
}