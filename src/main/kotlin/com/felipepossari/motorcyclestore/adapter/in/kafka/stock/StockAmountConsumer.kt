package com.felipepossari.motorcyclestore.adapter.`in`.kafka.stock

import com.felipepossari.motorcyclestore.adapter.`in`.kafka.stock.model.StockMessage
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@KafkaListener
class StockAmountConsumer {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    @Topic("\${kafka.topic.stockAmount}")
    fun receive(message: StockMessage){
        log.info("Message received from topic")
    }
}
