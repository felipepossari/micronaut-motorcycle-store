package com.felipepossari.motorcyclestore.adapter.out.kafka.stock

import com.felipepossari.motorcyclestore.adapter.out.kafka.stock.model.StockMessage
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.context.annotation.Property
import io.micronaut.context.annotation.Value

@KafkaClient
interface StockAmountPublisher {

    @Topic("\${kafka.topic.stockAmount}")
    fun publish(@KafkaKey key: String, message: StockMessage)
}