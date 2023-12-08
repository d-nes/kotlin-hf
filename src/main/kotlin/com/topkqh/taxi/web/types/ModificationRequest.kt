package com.topkqh.taxi.web.types

import com.topkqh.taxi.service.types.Customer
import com.topkqh.taxi.service.types.Driver

data class ModificationRequest (var driver: Driver, var customer: Customer)