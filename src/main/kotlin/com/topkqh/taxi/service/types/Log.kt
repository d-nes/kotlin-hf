package com.topkqh.taxi.service.types

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Time
import java.time.LocalDate

@Table("TAXI_LOG")
data class Log (@Id var id:String?, var time:Time?, var date:LocalDate?, val driver:String, val customer:String?, val message:String)