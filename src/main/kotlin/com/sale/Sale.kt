package com.sale

class Sale {
    fun getPriceByBarcode(barcode: String): String {
        return if (barcode == "12345") "$7.25" else if (barcode == "23456") "$12.50" else "Error: barcode not found"
    }

}
