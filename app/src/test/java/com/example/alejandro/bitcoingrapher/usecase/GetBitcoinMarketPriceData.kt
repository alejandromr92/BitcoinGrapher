package com.example.alejandro.bitcoingrapher.usecase

import com.example.alejandro.bitcoingrapher.domain.interactor.impl.GetBitcoinMarketPriceDataInteractorImpl
import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.presentation.presenter.GetBitcoinMarketPriceDataPresenter
import com.example.alejandro.bitcoingrapher.presentation.presenter.impl.GetBitcoinMarketPriceDataPresenterImpl
import com.nhaarman.mockitokotlin2.*
import org.junit.Test

class GetBitcoinMarketPriceData: BaseUseCase(){


    // Test subject
    private lateinit var presenter: GetBitcoinMarketPriceDataPresenterImpl

    // Mocked  values
    private val interactor: GetBitcoinMarketPriceDataInteractorImpl = mock()
    private val view: GetBitcoinMarketPriceDataPresenter.View = mock()

    override fun setup() {
        presenter = GetBitcoinMarketPriceDataPresenterImpl(interactor, view)
    }

    @Test
    fun testSuccess(){
        whenever(interactor.execute(any(), any())).then {
            view.onBitcoinMarketPriceRetrieved(listOf<BitcoinData>())
        }

        presenter.getBitcoinMarketPrice()

        verify(interactor).execute(any(), any())
        verify(interactor, times(1)).execute(any(), any())
        verify(view, times(1)).showProgress()
        verify(view, times(1)).onBitcoinMarketPriceRetrieved(any())
        verify(view, times(0)).onBitcoinMarketPriceRetrievingError()
    }

    @Test
    fun testError(){
        whenever(interactor.execute(any(), any())).then {
            view.onBitcoinMarketPriceRetrievingError()
        }

        presenter.getBitcoinMarketPrice()

        verify(interactor).execute(any(), any())
        verify(interactor, times(1)).execute(any(), any())
        verify(view, times(1)).showProgress()
        verify(view, times(0)).onBitcoinMarketPriceRetrieved(any())
        verify(view, times(1)).onBitcoinMarketPriceRetrievingError()
    }
}