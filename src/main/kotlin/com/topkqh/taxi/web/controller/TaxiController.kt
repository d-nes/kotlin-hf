package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.DriverService
import com.topkqh.taxi.service.LoggingService
import com.topkqh.taxi.service.types.Customer
import com.topkqh.taxi.service.types.Dispatch
import com.topkqh.taxi.service.types.Driver
import com.topkqh.taxi.service.types.Log
import com.topkqh.taxi.web.types.ModificationRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.random.Random


@Tag(name = "Taxi", description = "Taxi operation management APIs")
@RestController
@RequestMapping("/")
class TaxiController(val loggingService: LoggingService, val driverService: DriverService) {

    @Operation(
        summary = "Request a Taxi",
        description = "Request a Taxi by specifying customer's details")
    @PostMapping("/request")
    fun requestTaxi(@RequestBody customer: Customer): ResponseEntity<out Any> {
        val driver = driverService.dispatchDriver()
        if (driver != null) {
            loggingService.addLog(Log(null, null, null, driver.name, customer.name, "Dispatched for pick-up: from " + customer.location + " to " + customer.destination))
            return ResponseEntity.ok().body(Dispatch(driver, Random.nextInt(5, 61)))
        }
        return ResponseEntity.ok().body("No available drivers")
    }

    @Operation(
        summary = "Return Taxi",
        description = "Return Taxi to depo by specifying it's details")
    @PostMapping("/return")
    fun returnTaxi(@RequestBody driver: Driver): ResponseEntity<out Any> {
        val valid = driverService.returnDriver(driver)
        if (valid) {
            loggingService.addLog(Log(null, null, null, driver.name, null, "Driver has returned to depo"))
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Driver not busy or doesn't exist")

    }

    @Operation(
        summary = "Modify an already requested Taxi",
        description = "Modify Taxi request by specifying the Taxi's details, and the modified customer details")
    @PutMapping("/modify")
    fun modifyTaxi(@RequestBody request: ModificationRequest): ResponseEntity<out Any>  {
        if (driverService.isDriverBusy(request.driver)){
            loggingService.addLog(Log(null, null, null, request.driver.name, request.customer.name, "Dispatch modified, pick-up: from " + request.customer.location + " to " + request.customer.destination))
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Modification unsuccessful")
    }

    @Operation(
        summary = "Cancel a Taxi",
        description = "Cancel a Taxi by specifying Taxi's details")
    @DeleteMapping("/cancel")
    fun cancelTaxi(@RequestBody driver: Driver) : ResponseEntity<out Any> {
        if(driverService.isDriverBusy(driver)){
            loggingService.addLog(Log(null, null, null, driver.name, null, "Dispatch cancelled, driver has returned to depo"))
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Cancellation unsuccessful")
    }

}