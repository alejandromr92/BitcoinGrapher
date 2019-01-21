package com.example.alejandro.bitcoingrapher.network.model.dto

data class BitcoinDataResponseDto (
    val status: String,
    val name: String,
    val period: String,
    val description: String,
    val values: List<BitcoinDataDto>
)

data class BitcoinDataDto(
    val x: Long,
    val y: Double
)
