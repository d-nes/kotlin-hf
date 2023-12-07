package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.DriverService
import com.topkqh.taxi.service.types.Driver
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/driver")
class DriverController(val service: DriverService) {
    @PostMapping
    fun addDriver(@RequestBody driver: Driver){
        driver.id = driver.id ?: UUID.randomUUID().toString()
        service.addDriver(driver)
    }

    @GetMapping("/all")
    fun listDriver(): List<Driver> {
        return service.listDriver()
    }

}