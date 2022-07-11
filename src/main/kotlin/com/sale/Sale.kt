package com.sale

class Sale {
    fun getPriceByBarcode(barcode: String): String = when (barcode) {
        "" -> "Error: empty barcode"
        "12345" -> "$7.25"
        "23456" -> "$12.50"
        else -> "Error: barcode not found"
    }

}
