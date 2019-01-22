package com.example.alejandro.bitcoingrapher.presentation.presenter.impl

import com.example.alejandro.bitcoingrapher.domain.interactor.impl.GetBitcoinMarketPriceDataInteractorImpl
import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.presentation.presenter.GetBitcoinMarketPriceDataPresenter
import io.reactivex.Scheduler

class GetMarvelCharactersPresenterImpl(
    private val threadExecutor: Scheduler,
    private val mainThread: Scheduler,
    private val view: GetBitcoinMarketPriceDataPresenter.View
) : GetBitcoinMarketPriceDataPresenter {


    override fun getBitcoinMarketPrice() {
        view.showProgress()
        val interactor = GetBitcoinMarketPriceDataInteractorImpl(mainThread, threadExecutor)
        interactor.execute(::onBitcoinMarketPriceRetrieved, ::onBitcoinMarketPriceRetrievingError)
    }

    private fun onBitcoinMarketPriceRetrieved(bitcoinMarketPriceList: List<BitcoinData>){
        view.onBitcoinMarketPriceRetrieved(bitcoinMarketPriceList)
    }

    private fun onBitcoinMarketPriceRetrievingError(throwable: Throwable){
        view.onBitcoinMarketPriceRetrievingError()
    }
}