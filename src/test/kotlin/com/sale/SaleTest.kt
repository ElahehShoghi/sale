package com.sale

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class SaleTest {
    private val sale = Sale(PriceService())

    companion object {
        @JvmStatic
        fun barcodesWithTotalPriceArguments() = listOf(
            Arguments.of(arrayOf("12345", "23456"), "$19.75"),
            Arguments.of(arrayOf("12345", "23456", "4f7s"), "Error: barcode not found"),
            Arguments.of(arrayOf("12345", "", "4f7s"), "Error: empty barcode"),
        )
    }

    @ParameterizedTest
    @MethodSource("barcodesWithTotalPriceArguments")
    fun `should display sum of product prices correctly`(vararg barcodes: String, expectedResult: String) {
        assertEquals(expectedResult, sale.total(*barcodes))
    }
}