package com.example.alejandro.bitcoingrapher.network.service

interface Endpoints {
    companion object {
        const val BASE_URL = "https://api.blockchain.info/charts/"
        const val MARKET_PRICE = "market-price"
    }
}