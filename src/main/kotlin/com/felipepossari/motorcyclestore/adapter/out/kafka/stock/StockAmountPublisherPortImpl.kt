package com.felipepossari.motorcyclestore.adapter.out.kafka.stock

import com.felipepossari.motorcyclestore.adapter.out.kafka.stock.model.OperationType
import com.felipepossari.motorcyclestore.adapter.out.kafka.stock.model.StockMessage
import com.felipepossari.motorcyclestore.application.model.MotorcycleDto
import com.felipepossari.motorcyclestore.application.port.out.StockAmountPublisherPort
import javax.inject.Singleton

@Singleton
class StockAmountPublisherPortImpl(private val publisher: StockAmountPublisher) : StockAmountPublisherPort {
    override fun publishIncreaseStockMessage(motorcycleDto: MotorcycleDto) {
        publisher.publish(OperationType.INCREASE.name, buildIncreaseMessage(motorcycleDto))
    }

    override fun publishDecreaseStockMessage(motorcycleDto: MotorcycleDto) {
        publisher.publish(OperationType.DECREASE.name, buildDecreaseMessage(motorcycleDto))
    }
}