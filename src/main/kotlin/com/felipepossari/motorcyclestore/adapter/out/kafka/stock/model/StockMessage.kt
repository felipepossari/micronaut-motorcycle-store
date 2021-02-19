package com.felipepossari.motorcyclestore.adapter.out.kafka.stock.model

data class StockMessage(val id: Long, val price: Double, val operation: String) {
}