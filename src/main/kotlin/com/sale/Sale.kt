package com.sale

class Sale(private val priceService: PriceService) {

    fun total(vararg barcode: String) =
        "$${barcode.sumOf { priceService.getPriceByBarcode(it).replace("$", "").toDouble() }}"
}
