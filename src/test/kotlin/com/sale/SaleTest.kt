package com.sale

import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SaleTest {

    companion object{

        @JvmStatic
        fun saleItemsBarcodeAndPrice() = listOf(
            Arguments.of("12345", "$7.25"),
            Arguments.of("23456", "$12.5"),
        )
    }

    @MethodSource("saleItemsBarcodeAndPrice")
    @ParameterizedTest
    fun `should display correct price for barcode`(barcode: String, price: String){
        val input: Sale.BarcodeReader = mockk()
        every { input.invoke() } returns barcode
        val output: Sale.OutputWriter = mockk()
        every { output.invoke(any()) } just runs
        val sale = Sale(input, output)
        sale.startApp()
        verify {
            output.invoke(price)
        }
        verify(exactly = 1) {
            output.invoke(any())
        }
    }

    @Test
    fun `should output nothing for invalid barcode`(){
        val input: Sale.BarcodeReader = mockk()
        every { input.invoke() } returns "invalid barcode"
        val output: Sale.OutputWriter = mockk()
        val sale = Sale(input, output)
        sale.startApp()
        verify { input.invoke() }
    }

}