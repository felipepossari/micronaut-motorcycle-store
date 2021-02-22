package com.felipepossari.motorcyclestore.adapter.`in`.kafka.stock.model

data class StockMessage(val price: Double, val operationType: OperationType) {
}