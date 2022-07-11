package com.sale

import org.junit.Test
import kotlin.test.assertEquals

class SaleTest {

    @Test
    fun `should display price $7,25 for barcode 12345`() {
        assertEquals("$7.25", Sale().getPriceByBarcode("12345"))
    }
}