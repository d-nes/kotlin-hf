package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.LoggingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class TaxiController(val service: LoggingService) {

    @GetMapping
    fun index(): String {
        return "Hello"
    }

}