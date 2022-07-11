package com.sale

class PriceService {

    private val barcodePrice = mapOf(Pair("12345", "$7.25"), Pair("23456", "$12.50"))

    fun getPriceByBarcode(barcode: String): String =
        if (barcode.isEmpty())
            "Error: empty barcode"
        else barcodePrice[barcode] ?: "Error: barcode not found"
}