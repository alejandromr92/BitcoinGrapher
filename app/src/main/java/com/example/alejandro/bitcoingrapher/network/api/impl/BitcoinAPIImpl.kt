package com.example.alejandro.bitcoingrapher.network.api.impl

import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.network.api.BitcoinAPI
import com.example.alejandro.bitcoingrapher.network.interceptor.NonSecurityInterceptor
import com.example.alejandro.bitcoingrapher.network.model.dto.BitcoinMarketPriceRequest
import com.example.alejandro.bitcoingrapher.network.model.mapper.BitcoinDtoMapper
import com.example.alejandro.bitcoingrapher.network.service.BitcoinService
import com.example.alejandro.bitcoingrapher.network.service.Endpoints
import com.example.alejandro.bitcoingrapher.network.util.RetrofitClient
import io.reactivex.Single

class BitcoinAPIImpl: BitcoinAPI {
    private val service: BitcoinService =  RetrofitClient.getBitcoinService(Endpoints.BASE_URL, NonSecurityInterceptor())

    override fun getBitcoinMarketPrice(request: BitcoinMarketPriceRequest): Single<List<BitcoinData>> {
        val (timespan, rollingAverage) = BitcoinMarketPriceRequest()
        return service.getBitcoinMarketPrice(timespan, rollingAverage).map { BitcoinDtoMapper.map(it.values) }
    }
}

