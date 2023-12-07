package com.topkqh.taxi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class TaxiApplication

fun main(args: Array<String>) {
	runApplication<TaxiApplication>(*args)
}
