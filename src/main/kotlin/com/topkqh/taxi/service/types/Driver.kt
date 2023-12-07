package com.topkqh.taxi.service.types

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("TAXI_DRIVERS")
data class Driver (
    @Id var id: String,
    val name: String,
    val vehicle_id: String
)