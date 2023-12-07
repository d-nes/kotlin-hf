package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.LoggingService
import com.topkqh.taxi.service.types.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.sql.Time
import java.util.*

@RestController
class TaxiController(val service: LoggingService) {

    @GetMapping("/")
    fun index(): String {
        return "Hello"
    }

    @PostMapping("/log")
    fun addLog(@RequestBody log: Log){
        log.id = log.id ?: UUID.randomUUID().toString()
        log.time = Time(System.currentTimeMillis());
        service.addLog(log)
    }

    @GetMapping("/log")
    fun listLog(): List<Log> {
        return service.getLog()
    }

}