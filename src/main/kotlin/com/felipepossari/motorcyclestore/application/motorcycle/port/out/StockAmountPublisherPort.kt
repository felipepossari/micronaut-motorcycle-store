package com.felipepossari.motorcyclestore.application.motorcycle.port.out

import com.felipepossari.motorcyclestore.application.motorcycle.domain.Motorcycle

interface StockAmountPublisherPort {

    fun publishIncreaseStockMessage(motorcycle: Motorcycle)

    fun publishDecreaseStockMessage(motorcycle: Motorcycle)
}