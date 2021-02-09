package com.felipepossari.motorcyclestore

import io.micronaut.runtime.Micronaut.build
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
        info = Info(
                title = "motorcycle-store",
                version = "1.0.0",
                description = "Micronaut study project",
                license = License(name = "MIT")
        )
)
object Application {

}

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("com.felipepossari.motorcyclestore")
            .start()
}


