package com.example.alejandro.bitcoingrapher.presentation.presenter.impl

import com.example.alejandro.bitcoingrapher.domain.interactor.GetBitcoinMarketPriceDataInteractor
import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.presentation.presenter.GetBitcoinMarketPriceDataPresenter

class GetBitcoinMarketPriceDataPresenterImpl(
    private val interactor: GetBitcoinMarketPriceDataInteractor,
    private val view: GetBitcoinMarketPriceDataPresenter.View
) : GetBitcoinMarketPriceDataPresenter {


    override fun getBitcoinMarketPrice() {
        view.showProgress()
        interactor.execute(::onBitcoinMarketPriceRetrieved, ::onBitcoinMarketPriceRetrievingError)
    }

    private fun onBitcoinMarketPriceRetrieved(bitcoinMarketPriceList: List<BitcoinData>){
        if (bitcoinMarketPriceList.isNullOrEmpty()){
            view.onBitcoinMarketPriceRetrievingError()
        } else {
            view.onBitcoinMarketPriceRetrieved(bitcoinMarketPriceList)
        }
    }

    private fun onBitcoinMarketPriceRetrievingError(throwable: Throwable){
        view.onBitcoinMarketPriceRetrievingError()
    }
}