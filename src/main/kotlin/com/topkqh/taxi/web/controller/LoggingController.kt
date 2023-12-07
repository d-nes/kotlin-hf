package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.LoggingService
import com.topkqh.taxi.service.types.Log
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Time
import java.util.*

@RestController
@RequestMapping("/log")
class LoggingController(val service: LoggingService) {

    @PostMapping
    fun addLog(@RequestBody log: Log){
        service.addLog(log)
    }

    @GetMapping
    fun listLog(): List<Log> {
        return service.getLog()
    }
}