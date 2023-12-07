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
        driver.id = driver.id ?: UUID.randomUUID().toString()
        service.addDriver(driver)
    }

    @GetMapping("/all")
    fun listDriver(): List<Driver> {
        return service.listDriver()
    }

    @GetMapping("/id")
    fun findDriverById(@RequestParam id: String): List<Driver> {
        return service.findDriverById(id)
    }

    @GetMapping("/name")
    fun findDriverByName(@RequestParam name: String): List<Driver> {
        return service.findDriverByName(name)
    }

    @GetMapping("/licence")
    fun findDriverByLicence(@RequestParam licence: String): List<Driver> {
        return service.findDriverByLicence(licence)
    }

    @DeleteMapping
    fun deleteDriver(@RequestParam id: String): ResponseEntity<out Any> {
        if (service.deleteDriver(id))
            return ResponseEntity.ok().build()
        return ResponseEntity.badRequest().body("No such driver")
    }

}