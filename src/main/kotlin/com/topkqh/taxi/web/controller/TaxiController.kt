package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.DriverService
import com.topkqh.taxi.service.LoggingService
import com.topkqh.taxi.service.types.Customer
import com.topkqh.taxi.service.types.Dispatch
import com.topkqh.taxi.service.types.Driver
import com.topkqh.taxi.service.types.Log
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
@RequestMapping("/")
class TaxiController(val loggingService: LoggingService, val driverService: DriverService) {

    @PostMapping("/request")
    fun requestTaxi(@RequestBody customer: Customer): ResponseEntity<out Any> {
        val driver = driverService.dispatchDriver()
        if (driver != null) {
            loggingService.addLog(Log(null, null, null, driver.name, customer.name, "Dispatched for pick-up: from " + customer.location + " to " + customer.destination))
            return ResponseEntity.ok().body(Dispatch(driver, Random.nextInt(5, 61)))
        }
        return ResponseEntity.ok().body("No available drivers")
    }

    @PostMapping("/return")
    fun returnTaxi(@RequestBody driver: Driver): ResponseEntity<out Any> {
        val valid = driverService.returnDriver(driver)
        return if (valid) {
            loggingService.addLog(Log(null, null, null, driver.name, null, "Driver has return to depo"))
            ResponseEntity.ok().build();
        } else
            ResponseEntity.badRequest().body("Driver not busy or doesn't exist")

    }

}