package com.example.alejandro.bitcoingrapher.presentation.ui.activities

import android.os.Bundle
import com.example.alejandro.bitcoingrapher.R
import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.presentation.presenter.GetBitcoinMarketPriceDataPresenter
import com.example.alejandro.bitcoingrapher.presentation.presenter.impl.GetMarvelCharactersPresenterImpl
import com.example.alejandro.bitcoingrapher.utils.LoggerUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity(),
GetBitcoinMarketPriceDataPresenter.View {

    private var getBitcoinMarketPriceDataPresenter: GetBitcoinMarketPriceDataPresenter? = null

    private var bitcoinPriceList: MutableSet<BitcoinData>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        this.layout = R.layout.activity_main

        super.onCreate(savedInstanceState)
    }

    override fun initializePresenters() {
        super.initializePresenters()

        this.getBitcoinMarketPriceDataPresenter = GetMarvelCharactersPresenterImpl(
            Schedulers.newThread(),
            AndroidSchedulers.mainThread(),
            this
        )
    }

    override fun loadData() {
        super.loadData()

        this.getBitcoinMarketPriceDataPresenter!!.getBitcoinMarketPrice()
    }

    // Callbacks
    override fun onBitcoinMarketPriceRetrieved(bitcoinMarketPriceList: List<BitcoinData>) {
        bitcoinPriceList!!.addAll(bitcoinMarketPriceList)
    }

    override fun onBitcoinMarketPriceRetrievingError() {
        LoggerUtils.logMessage("BITCOIN DATA", "Error")
    }
}
