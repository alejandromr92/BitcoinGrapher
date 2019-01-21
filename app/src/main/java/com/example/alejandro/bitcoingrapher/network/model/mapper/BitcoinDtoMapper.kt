package com.example.alejandro.bitcoingrapher.network.model.mapper

import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.network.model.dto.BitcoinDataDto

abstract class BitcoinDtoMapper {
    companion object {
        fun map(bitcoinDataList: List<BitcoinDataDto>): List<BitcoinData> {
            val list = ArrayList<BitcoinData>()

            if (bitcoinDataList.isNotEmpty()){
                for (bd in bitcoinDataList){
                    list.add(map(bd))
                }
            }

            return list
        }

        fun map(dto: BitcoinDataDto) = BitcoinData(
            dto.x,
            dto.y
        )
    }
}