package com.example.alejandro.bitcoingrapher.network

interface Constants {
    companion object {
        const val READ_TIME_OUT = 60L
        const val WRITE_TIME_OUT = 60L
        const val CONNECT_TIME_OUT = 60L

        const val TIMESPAN = "4weeks"
        const val ROLLING_AVERAGE = "8hours"
    }
}
