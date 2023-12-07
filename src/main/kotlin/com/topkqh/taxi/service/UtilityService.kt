package com.topkqh.taxi.service

import com.google.gson.Gson
import com.topkqh.taxi.service.types.Driver
import org.springframework.stereotype.Service
import java.io.File

@Service
class UtilityService(val service: DriverService) {
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