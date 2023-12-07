package com.topkqh.taxi.service

import com.topkqh.taxi.service.types.Driver
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class DriverService(val db: JdbcTemplate) {
    fun addDriver(driver: Driver) {
        db.update("insert into TAXI_DRIVERS values ( ?, ?, ?)",
                driver.id, driver.name, driver.vehicle_id
        )
        println("Driver added: " + driver.toString())
    }

    fun listDriver(): List<Driver> {
        return db.query("select * from TAXI_DRIVERS") { response, _ ->
            Driver(response.getString("id"),
                    response.getString("name"),
                    response.getString("vehicle_id"))
        }
    }
}