package com.topkqh.taxi.service.types

import java.sql.Time

data class Log (var id:String?, var time:Time?, val driver:String, val customer:String?, val message:String)