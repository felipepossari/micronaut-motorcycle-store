package com.felipepossari.motorcyclestore.application.port.out

import com.felipepossari.motorcyclestore.application.model.MotorcycleDto

interface StockAmountPublisherPort {

    fun publishIncreaseStockMessage(motorcycleDto: MotorcycleDto)

    fun publishDecreaseStockMessage(motorcycleDto: MotorcycleDto)
}