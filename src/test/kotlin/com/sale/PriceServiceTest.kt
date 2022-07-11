package com.sale

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PriceServiceTest {
    private val priceService = PriceService()

    companion object {
        @JvmStatic
        fun barcodeArguments() = listOf(
            Arguments.of("12345", "$7.25"),
            Arguments.of("23456", "$12.50"),
            Arguments.of("99999", "Error: barcode not found"),
            Arguments.of("", "Error: empty barcode"),
        )
    }

    @ParameterizedTest
    @MethodSource("barcodeArguments")
    fun `should display correct price for a barcode`(barcode: String, expectedPrice: String) {
        assertEquals(expectedPrice, priceService.getPriceByBarcode(barcode))
    }
}