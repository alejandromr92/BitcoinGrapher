package com.example.alejandro.bitcoingrapher.domain.interactor.impl

import com.example.alejandro.bitcoingrapher.domain.interactor.GetBitcoinMarketPriceDataInteractor
import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.network.api.impl.BitcoinAPIImpl
import com.example.alejandro.bitcoingrapher.network.model.dto.BitcoinMarketPriceRequest
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposables

class GetBitcoinMarketPriceDataInteractorImpl(
    private val observeOn: Scheduler,
    private val subscribeOn: Scheduler
): GetBitcoinMarketPriceDataInteractor {
    private val api = BitcoinAPIImpl()

    private var subscription = Disposables.empty()

    override fun execute(onComplete: (List<BitcoinData>) -> Unit, onError: (Throwable) -> Unit) {
        subscription = api.getBitcoinMarketPrice(BitcoinMarketPriceRequest())
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
            .subscribe(onComplete, onError)
    }
}