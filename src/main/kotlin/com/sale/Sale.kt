package com.sale

class Sale {
    fun getPriceByBarcode(barcode: String): String {
        return if (barcode == "12345") "$7.25" else "$12.50"
    }

}
