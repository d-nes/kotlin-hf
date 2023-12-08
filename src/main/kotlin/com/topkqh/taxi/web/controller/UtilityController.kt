package com.topkqh.taxi.web.controller

import com.topkqh.taxi.service.UtilityService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Utility", description = "Development and Testing APIs")

@RestController
@RequestMapping("/utility")
class UtilityController(val service: UtilityService) {

    @Operation(
        summary = "Initialize drivers using example data",
        description = "Creates 10 example drivers for testing")
    @PostMapping("init")
    fun init(): String {
        service.readDrivers()
        return "Database initialized with sample data"
    }
}