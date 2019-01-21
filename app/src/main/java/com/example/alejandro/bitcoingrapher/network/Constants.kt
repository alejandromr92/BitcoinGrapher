package com.example.alejandro.bitcoingrapher.network

interface Constants {
    companion object {
        const val READ_TIME_OUT = 60L
        const val WRITE_TIME_OUT = 60L
        const val CONNECT_TIME_OUT = 60L

        const val TIMESPAN_KEY = "timespan"
        const val TIMESPAN_VALUE = "4weeks"
        const val ROLLING_AVERAGE_KEY = "rollingAverage"
        const val ROLLING_AVERAGE_VALUE = "8hours"
    }
}
