package com.topkqh.taxi.web.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TaxiController {

    @GetMapping("/")
    fun index(): String {
        return "Hello"
    }

}