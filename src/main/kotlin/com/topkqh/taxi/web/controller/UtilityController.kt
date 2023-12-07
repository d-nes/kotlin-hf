package com.topkqh.taxi.web.controller

import com.google.gson.Gson
import com.topkqh.taxi.service.DriverService
import com.topkqh.taxi.service.types.Driver
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
@RequestMapping("/utility")
class UtilityController(val service: DriverService) {

    @PostMapping("init")
    fun init(): String {
        readDrivers()
        return "Database initialized with sample data"
    }

    fun readDrivers() {
        try {
            val file = File("src/main/resources/drivers.json")
            val gson = Gson()
            val jsonString = file.readText()
            val drivers = gson.fromJson(jsonString, Array<Driver>::class.java)
            for (driver in drivers) {
                service.addDriver(driver)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}