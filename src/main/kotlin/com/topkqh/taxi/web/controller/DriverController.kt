package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.DriverService
import com.topkqh.taxi.service.types.Driver
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.repository.query.Param
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Driver", description = "Driver management APIs")
@RestController
@RequestMapping("/driver")
class DriverController(val service: DriverService) {
    @Operation(
        summary = "Add driver",
        description = "Add a driver to the depo")
    @PostMapping
    fun addDriver(@RequestBody driver: Driver){
        service.addDriver(driver)
    }

    @Operation(
        summary = "List drivers",
        description = "Get a list of all drivers")
    @GetMapping("/all")
    fun listDriver(): List<Driver> {
        return service.listDriver()
    }

    @Operation(
        summary = "Find driver",
        description = "Find a driver by knowing his id")
    @GetMapping
    fun findDriverById(@RequestParam id: String): List<Driver> {
        return service.findDriverById(id)
    }

    @Operation(
        summary = "Delete driver",
        description = "Delete a driver from the depo")
    @DeleteMapping
    fun deleteDriver(@RequestParam id: String) {
        service.deleteDriver(id)
    }

    @Operation(
        summary = "Update driver",
        description = "Update a driver in the depo")
    @PutMapping
    fun updateDriver(@RequestBody driver: Driver) {
        service.updateDriver(driver)
    }

}