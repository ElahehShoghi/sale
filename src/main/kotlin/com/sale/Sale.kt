package com.sale

class Sale(private val priceService: PriceService) {

    fun total(vararg barcode: String): String {
        val barcodePrice = barcode.map { priceService.getPriceByBarcode(it) }
        val errorMessage = barcodePrice.firstOrNull { !it.contains("$") }
        return errorMessage ?: "$${barcodePrice.sumOf { it.replace("$", "").toDouble() }}"
    }
}
