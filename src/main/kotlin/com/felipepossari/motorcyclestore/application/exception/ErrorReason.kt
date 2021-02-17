package com.felipepossari.motorcyclestore.application.exception

import com.felipepossari.motorcyclestore.application.exception.Module.MOTORCYCLE

private enum class Module(val module: String){
    MOTORCYCLE("001"),
    USER("002")
}

enum class ErrorReason(
        private val module: String,
        private val errorCode: String,
        val message: String) {

    MOTORCYCLE_INVALID_BRAND(MOTORCYCLE.module, "001", "Brand cannot be null or bigger than 255 characters"),
    MOTORCYCLE_INVALID_MODEL(MOTORCYCLE.module, "002", "Model cannot be null or bigger than 255 characters"),
    MOTORCYCLE_INVALID_CUBIC_CYLINDER(MOTORCYCLE.module, "003", "Cubic cylinder cannot be null or lower than zero"),
    MOTORCYCLE_INVALID_MANUFACTURE_YEAR(MOTORCYCLE.module, "004", "Manufacture year cannot be null or lower than zero"),
    MOTORCYCLE_INVALID_MODEL_YEAR(MOTORCYCLE.module, "005", "Model year cannot be null or lower than zero"),
    MOTORCYCLE_INVALID_PRICE(MOTORCYCLE.module, "006", "Price cannot be null or lower than zero"),

    MOTORCYCLE_ID_NOT_FOUND(MOTORCYCLE.module, "015", "Motorcycle not found");

    val code: String get() = "$module$errorCode"
    
}