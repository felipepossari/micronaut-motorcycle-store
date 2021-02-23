package com.felipepossari.motorcyclestore.adapter.out.kafka.stock

import com.felipepossari.motorcyclestore.adapter.out.kafka.stock.model.OperationType
import com.felipepossari.motorcyclestore.adapter.out.kafka.stock.model.StockMessage
import com.felipepossari.motorcyclestore.application.motorcycle.domain.Motorcycle

fun buildIncreaseMessage(motorcycle: Motorcycle) =
        buildMessage(motorcycle, OperationType.INCREASE)

fun buildDecreaseMessage(motorcycle: Motorcycle) =
        buildMessage(motorcycle, OperationType.DECREASE)

private fun buildMessage(motorcycle: Motorcycle, operationType: OperationType) =
        StockMessage(
                price = motorcycle.price,
                operationType = operationType
        )