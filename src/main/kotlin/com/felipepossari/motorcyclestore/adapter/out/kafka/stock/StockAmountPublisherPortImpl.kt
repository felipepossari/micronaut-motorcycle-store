package com.felipepossari.motorcyclestore.adapter.out.kafka.stock

import com.felipepossari.motorcyclestore.adapter.out.kafka.stock.model.StockMessage
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.out.StockAmountPublisherPort
import javax.inject.Singleton

@Singleton
class StockAmountPublisherPortImpl(private val publisher: StockAmountPublisher) : StockAmountPublisherPort {
    override fun publishIncreaseStockMessage(motorcycleDto: MotorcycleDto) {
        val message = StockMessage(
                id = 0L,
                price = motorcycleDto.price,
                operation = "INCREASE"
        )
        publisher.publish("INCREASE", message)
    }

    override fun publishDecreaseStockMessage(motorcycleDto: MotorcycleDto) {
        TODO("Not yet implemented")
    }

    override fun publishUpdateStockMessage(motorcycleDto: MotorcycleDto) {
        TODO("Not yet implemented")
    }
}