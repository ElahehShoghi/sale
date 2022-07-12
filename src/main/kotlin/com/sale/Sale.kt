package com.sale

class Sale(private val inputReader: BarcodeReader, private val outputWriter: OutputWriter) {



    fun startApp() {
        val inputBarcode = inputReader()
        if (inputBarcode == "23456")
            outputWriter("$12.5")
        else if (inputBarcode == "12345")
            outputWriter("$7.25")
    }

    fun interface BarcodeReader {
        operator fun invoke(): String
    }

    fun interface OutputWriter {
        operator fun invoke(outputString: String)
    }
}

fun main() {
    val sale = Sale({
        readln()
    },
        {
            println(it)
        })
    sale.startApp()
}
