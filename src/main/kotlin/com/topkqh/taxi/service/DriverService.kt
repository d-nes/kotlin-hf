package com.topkqh.taxi.service

import com.topkqh.taxi.service.types.Driver
import com.topkqh.taxi.service.types.DriverRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.toList

@Service
class DriverService(val db: DriverRepository) {

    fun addDriver(driver: Driver) {
        driver.id = null
        db.save(driver)
        println("Driver added: $driver")
    }

    fun listDriver(): List<Driver> {
        return db.findAll().toList()
    }

    fun findDriverById(id: String): List<Driver> {
        return db.findById(id).toList()
    }

    fun deleteDriver(id: String) {
        db.deleteById(id)
    }

    fun updateDriver(driver: Driver) {
        db.save(driver)
        println("Driver modified: $driver")
    }

    var busyDrivers: MutableList<Driver> = mutableListOf()

    fun dispatchDriver(): Driver?{
        for (driver in listDriver()){
            if(!busyDrivers.contains(driver)){
                busyDrivers.add(driver)
                return driver
            }
        }
        return null
    }

    fun returnDriver(driver: Driver): Boolean {
        return busyDrivers.remove(driver)
    }

    fun isDriverBusy(driver: Driver): Boolean {
        return busyDrivers.contains(driver)
    }
}