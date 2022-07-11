package com.sale

class Sale(private val priceService: PriceService) {

    fun total(vararg barcode: String): String {
        val errorMessage = barcode.map { priceService.getPriceByBarcode(it) }.firstOrNull { !it.contains("$") }
        return errorMessage ?: "$${barcode.sumOf { priceService.getPriceByBarcode(it).replace("$", "").toDouble() }}"
    }
}
