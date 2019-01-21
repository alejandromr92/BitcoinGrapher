package com.example.alejandro.bitcoingrapher.domain.interactor

import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData

interface GetBitcoinMarketPriceDataInteractor {
    fun execute(onComplete: (List<BitcoinData>) -> Unit, onError: (Throwable) -> Unit)
}