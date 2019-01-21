package com.example.alejandro.bitcoingrapher.network.model.dto

import com.example.alejandro.bitcoingrapher.network.Constants

data class BitcoinMarketPriceRequest(
    val timespan: String = Constants.TIMESPAN_VALUE,
    val rollingAverage: String = Constants.ROLLING_AVERAGE_VALUE
)