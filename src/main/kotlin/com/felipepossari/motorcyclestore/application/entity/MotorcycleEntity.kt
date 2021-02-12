package com.felipepossari.motorcyclestore.application.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "motorcycle")
data class MotorcycleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,
        val brand: String = "",
        val model: String = "",
        val cubicCylinder: Int = 0,
        val manufactureYear: Int = 0,
        val modelYear: Int = 0,
        val price: Double = 0.0
)