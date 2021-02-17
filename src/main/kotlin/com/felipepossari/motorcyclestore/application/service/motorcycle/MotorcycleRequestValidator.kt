package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.application.exception.ErrorReason
import com.felipepossari.motorcyclestore.application.exception.InvalidArgumentException
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import javax.inject.Singleton

@Singleton
class MotorcycleRequestValidator {

    fun validateCreateRequest(dto: MotorcycleDto) {
        val errors = mutableListOf<ErrorReason>()
        validateBrand(dto.brand)?.let { errors.add(it) }
        validateModel(dto.model)?.let { errors.add(it) }
        if(errors.isNotEmpty()){
            throw InvalidArgumentException(errors)
        }
    }

    private fun validateBrand(brand: String): ErrorReason? =
            if (brand.isEmpty() || brand.length > 255) {
                ErrorReason.MOTORCYCLE_INVALID_BRAND
            } else {
                null
            }

    private fun validateModel(model: String): ErrorReason? =
            if (model.isEmpty() || model.length > 255) {
                ErrorReason.MOTORCYCLE_INVALID_MODEL
            } else {
                null
            }


}