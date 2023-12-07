package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.DriverService
import com.topkqh.taxi.service.types.Driver
import org.springframework.data.repository.query.Param
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/driver")
class DriverController(val service: DriverService) {
    @PostMapping
    fun addDriver(@RequestBody driver: Driver){
        service.addDriver(driver)
    }

    @GetMapping("/all")
    fun listDriver(): List<Driver> {
        return service.listDriver()
    }

    @GetMapping
    fun findDriverById(@RequestParam id: String): List<Driver> {
        return service.findDriverById(id)
    }

    @DeleteMapping
    fun deleteDriver(@RequestParam id: String) {
        service.deleteDriver(id)
    }

    @PutMapping
    fun updateDriver(@RequestBody driver: Driver) {
        service.updateDriver(driver)
    }

}