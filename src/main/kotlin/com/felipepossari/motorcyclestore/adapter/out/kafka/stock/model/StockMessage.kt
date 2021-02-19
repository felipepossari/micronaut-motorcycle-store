package com.felipepossari.motorcyclestore.adapter.out.kafka.stock.model

data class StockMessage(val price: Double, val operationType: OperationType) {
}