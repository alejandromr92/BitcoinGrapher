package com.example.alejandro.bitcoingrapher.network.model.mapper

import android.text.format.DateFormat
import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.network.model.dto.BitcoinDataDto
import java.util.*

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
            dto.y,
            DateFormat.format("dd MMM" ,Date(dto.x * 1000)).toString()
        )
    }
}