package com.topkqh.taxi.service

import com.topkqh.taxi.service.types.Log
import com.topkqh.taxi.service.types.LogRepository
import org.springframework.stereotype.Service
import java.sql.Time
import java.time.LocalDate

@Service
class LoggingService(val db: LogRepository) {
    fun addLog(log: Log) {
        log.date = LocalDate.now()
        log.time = Time(System.currentTimeMillis());
        db.save(log)
        println("Log added: $log")
    }

    fun getLog():List<Log> {
        return db.findAll().toList()
    }

    fun wipeLog() {
        db.deleteAll()
    }
}