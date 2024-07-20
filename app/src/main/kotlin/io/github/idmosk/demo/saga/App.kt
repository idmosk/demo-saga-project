package io.github.idmosk.demo.saga

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@AutoConfiguration
open class DemoSagaApplication

fun main(args: Array<String>) {
    runApplication<DemoSagaApplication>(*args)
}
