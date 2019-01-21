package com.example.alejandro.bitcoingrapher.presentation.presenter

import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData

interface GetBitcoinMarketPriceDataPresenter {
    fun getBitcoinMarketPrice()

    interface View: BaseView {
        fun onBitcoinMarketPriceRetrieved(bitcoinMarketPriceList: List<BitcoinData>)
        fun onBitcoinMarketPriceRetrievingError()
    }
}