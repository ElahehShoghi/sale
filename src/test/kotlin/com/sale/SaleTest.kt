package com.sale

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SaleTest {
    private val sale = Sale(PriceService())

    @Test
    fun `should display the sum of the scanned product prices`() {
        assertEquals("$19.75", sale.total("12345", "23456"))
    }

    @Test
    fun `should display appropriate message for invalid barcode`() {
        assertEquals("Error: barcode not found", sale.total("12345", "23456", "4f7s"))
    }
}