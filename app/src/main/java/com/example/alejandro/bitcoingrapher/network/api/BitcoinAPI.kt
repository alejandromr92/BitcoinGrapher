package com.example.alejandro.bitcoingrapher.network.api

import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.network.model.dto.BitcoinMarketPriceRequest
import io.reactivex.Single

interface BitcoinAPI {
    fun getBitcoinMarketPrice(request: BitcoinMarketPriceRequest): Single<List<BitcoinData>>
}