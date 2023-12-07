package com.topkqh.taxi.service

import com.topkqh.taxi.service.types.Log
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.sql.Time
import java.util.*

@Service
class LoggingService(val db: JdbcTemplate) {
    fun addLog(log: Log) {
        log.id = log.id ?: UUID.randomUUID().toString()
        log.time = Time(System.currentTimeMillis());
        db.update(
                "insert into TAXI_LOG values ( ?, ?, ?, ?, ?)",
                log.id, log.time, log.driver, log.customer, log.message
        )
        println("Log added: $log")
    }

    fun getLog():List<Log> {
        return db.query("select * from TAXI_LOG") { response, _ ->
            Log(response.getString("id"),
                    response.getTime("time"),
                    response.getString("driver"),
                    response.getString("customer"),
                    response.getString("message"))
        }
    }
}