package com.sale

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SaleTest {
    private val sale = Sale(PriceService())

    @Test
    fun `should display the sum of the scanned product prices`() {
        assertEquals("$19.75", sale.total("12345", "23456"))
    }
}