package com.felipepossari.motorcyclestore.application.model

data class MotorcycleDto(
        val id:Long? = 0,
        val brand: String = "",
        val model: String = "",
        val cubicCylinder: Int = 0,
        val manufactureYear: Int = 0,
        val modelYear: Int = 0,
        val price: Double = 0.0
)