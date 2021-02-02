package com.felipepossari.motorcyclestore

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.felipepossari.motorcyclestore")
		.start()
}

