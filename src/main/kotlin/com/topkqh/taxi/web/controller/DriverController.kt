package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.DriverService
import com.topkqh.taxi.service.types.Driver
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class DriverController(val service: DriverService) {
    @PostMapping("/driver")
    fun addDriver(@RequestBody driver: Driver){
        driver.id = driver.id ?: UUID.randomUUID().toString()
        service.addDriver(driver)
    }

    @GetMapping("/driver/all")
    fun listDriver(): List<Driver> {
        return service.listDriver()
    }

}