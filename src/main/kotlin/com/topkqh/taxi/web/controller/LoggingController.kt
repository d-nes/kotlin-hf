package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.LoggingService
import com.topkqh.taxi.service.types.Log
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Time
import java.util.*

@Tag(name = "Log", description = "Log management APIs")
@RestController
@RequestMapping("/log")
class LoggingController(val service: LoggingService) {

    @Operation(
        summary = "Add a record to the log")
    @PostMapping
    fun addLog(@RequestBody log: Log){
        service.addLog(log)
    }

    @Operation(
        summary = "Get all the records from the log")
    @GetMapping
    fun listLog(): List<Log> {
        return service.getLog()
    }

    @Operation(
        summary = "Delete all the records from the log")
    @DeleteMapping
    fun wipeLog() {
        service.wipeLog()
    }
}