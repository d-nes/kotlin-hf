package com.topkqh.taxi.service

import com.topkqh.taxi.service.types.Driver
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service

@Service
class DriverService(val db: JdbcTemplate) {

    fun addDriver(driver: Driver) {
        db.update("insert into TAXI_DRIVERS values ( ?, ?, ?)",
                driver.id, driver.name, driver.vehicle_id
        )
        println("Driver added: $driver")
    }

    fun listDriver(): List<Driver> {
        return db.query("select * from TAXI_DRIVERS") { response, _ ->
            Driver(response.getString("id"),
                    response.getString("name"),
                    response.getString("vehicle_id"))
        }
    }

    fun findDriverById(id: String): List<Driver> {
        return db.query("select * from TAXI_DRIVERS where id = ?", id) { response, _ ->
            Driver(response.getString("id"), response.getString("name"), response.getString("vehicle_id"))
        }
    }

    fun findDriverByName(name: String): List<Driver> {
        return db.query("select * from TAXI_DRIVERS where name = ?", name) { response, _ ->
            Driver(response.getString("id"), response.getString("name"), response.getString("vehicle_id"))
        }
    }

    fun findDriverByLicence(id: String): List<Driver> {
        return db.query("select * from TAXI_DRIVERS where vehicle_id = ?", id) { response, _ ->
            Driver(response.getString("id"), response.getString("name"), response.getString("vehicle_id"))
        }
    }

    fun deleteDriver(id: String): Boolean {
        return db.update("delete from TAXI_DRIVERS where id = ?", id) > 0
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
}