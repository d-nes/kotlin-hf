package com.topkqh.taxi.web.controller

import com.google.gson.Gson
import com.topkqh.taxi.service.DriverService
import com.topkqh.taxi.service.UtilityService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/utility")
class UtilityController(val service: UtilityService) {

    @PostMapping("init")
    fun init(): String {
        service.readDrivers()
        return "Database initialized with sample data"
    }
}