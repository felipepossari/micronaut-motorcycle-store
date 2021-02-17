package com.felipepossari.motorcyclestore.application.service.motorcycle

import com.felipepossari.motorcyclestore.application.exception.ErrorReason
import com.felipepossari.motorcyclestore.application.exception.InvalidArgumentException
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import javax.inject.Singleton

@Singleton
class MotorcycleRequestValidator {

    companion object{
        private const val BRAND_MAX_LENGHT: Int = 255
        private const val MODEL_MAX_LENGHT: Int = 255
    }

    fun validateCreateRequest(dto: MotorcycleDto) {
        val errors = mutableListOf<ErrorReason>()
        validateBrand(dto.brand)?.let { errors.add(it) }
        validateModel(dto.model)?.let { errors.add(it) }
        validateCubicCylinder(dto.cubicCylinder)?.let { errors.add(it) }
        validateManufactureYear(dto.manufactureYear)?.let { errors.add(it) }
        validateModelYear(dto.modelYear)?.let { errors.add(it) }
        validatePrice(dto.price)?.let { errors.add(it) }
        if (errors.isNotEmpty()) {
            throw InvalidArgumentException(errors)
        }
    }

    private fun validateBrand(brand: String): ErrorReason? =
            if (brand.isEmpty() || brand.length > BRAND_MAX_LENGHT) {
                ErrorReason.MOTORCYCLE_INVALID_BRAND
            } else {
                null
            }

    private fun validateModel(model: String): ErrorReason? =
            if (model.isEmpty() || model.length > MODEL_MAX_LENGHT) {
                ErrorReason.MOTORCYCLE_INVALID_MODEL
            } else {
                null
            }

    private fun validateCubicCylinder(cubicCylinder: Int): ErrorReason? =
            if (cubicCylinder <= 0) {
                ErrorReason.MOTORCYCLE_INVALID_CUBIC_CYLINDER
            } else {
                null
            }

    private fun validateManufactureYear(manufactureYear: Int): ErrorReason? =
            if (manufactureYear <= 0) {
                ErrorReason.MOTORCYCLE_INVALID_MANUFACTURE_YEAR
            } else {
                null
            }

    private fun validateModelYear(modelYear: Int): ErrorReason? =
            if (modelYear <= 0) {
                ErrorReason.MOTORCYCLE_INVALID_MODEL_YEAR
            } else {
                null
            }

    private fun validatePrice(price: Double): ErrorReason? =
            if (price <= 0) {
                ErrorReason.MOTORCYCLE_INVALID_PRICE
            } else {
                null
            }
}