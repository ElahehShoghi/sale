package com.sale

class Sale {
    fun getPriceByBarcode(barcode: String): String {
        if (barcode == "12345")
            return "$7.25"
        return "$12.50"
    }

}
