package com.example.alejandro.bitcoingrapher.network.service

import com.example.alejandro.bitcoingrapher.network.Constants
import com.example.alejandro.bitcoingrapher.network.model.dto.BitcoinDataResponseDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BitcoinService {

    @GET(Endpoints.MARKET_PRICE)
    fun getBitcoinMarketPrice(
        @Query(Constants.TIMESPAN) timespan: String,
        @Query(Constants.ROLLING_AVERAGE) rollingAverage: String
    ) : Single<BitcoinDataResponseDto>
}