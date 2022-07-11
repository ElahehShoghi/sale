package com.sale

class Sale {
    fun getPriceByBarcode(barcode: String): String = when (barcode) {
        "" -> "Error: empty barcode"
        "12345" -> "$7.25"
        "23456" -> "$12.50"
        else -> "Error: barcode not found"
    }

    fun total(barcode1: String, barcode2: String): String {
        return "$${
            getPriceByBarcode(barcode1).replace("$", "").toDouble() + getPriceByBarcode(barcode2).replace("$", "").toDouble()
        }"
    }

}
