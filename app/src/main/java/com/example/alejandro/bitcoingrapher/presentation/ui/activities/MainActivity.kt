package com.example.alejandro.bitcoingrapher.presentation.ui.activities

import android.os.Bundle
import com.example.alejandro.bitcoingrapher.R
import com.example.alejandro.bitcoingrapher.domain.interactor.impl.GetBitcoinMarketPriceDataInteractorImpl
import com.example.alejandro.bitcoingrapher.domain.model.BitcoinData
import com.example.alejandro.bitcoingrapher.presentation.presenter.GetBitcoinMarketPriceDataPresenter
import com.example.alejandro.bitcoingrapher.presentation.presenter.impl.GetBitcoinMarketPriceDataPresenterImpl
import com.example.alejandro.bitcoingrapher.utils.LoggerUtils
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.DataSet
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),
GetBitcoinMarketPriceDataPresenter.View {

    private var getBitcoinMarketPriceDataPresenter: GetBitcoinMarketPriceDataPresenter? = null

    private var bitcoinPriceListEntries: MutableList<Entry> = mutableListOf()

    private lateinit var bitcoinDataSet: DataSet<Entry>

    private var bitcoinPriceDates: MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        this.layout = R.layout.activity_main

        super.onCreate(savedInstanceState)
    }

    override fun initializePresenters() {
        super.initializePresenters()

        this.getBitcoinMarketPriceDataPresenter = GetBitcoinMarketPriceDataPresenterImpl(
            GetBitcoinMarketPriceDataInteractorImpl(Schedulers.newThread(), AndroidSchedulers.mainThread()),
            this
        )
    }

    override fun loadData() {
        super.loadData()

        this.getBitcoinMarketPriceDataPresenter!!.getBitcoinMarketPrice()
    }

    private fun setGraphData(bitcoinMarketPriceList: List<BitcoinData>){
        if (!bitcoinMarketPriceList.isNullOrEmpty()){
            var i = 0f
            for (bitcoinData in bitcoinMarketPriceList){
                bitcoinPriceListEntries.add(Entry(i, bitcoinData.value))
                i++
                bitcoinPriceDates.add(bitcoinData.date)
            }
        }

        bitcoinDataSet = LineDataSet(bitcoinPriceListEntries, "Bitcoin Market Price (USD)")

        val lineData = LineData(bitcoinDataSet as LineDataSet)

        // X axis
        val xAxis =  data_graph.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setValueFormatter { value, axis -> bitcoinPriceDates[value.toInt()] }
        xAxis.labelRotationAngle = 40f
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f

        // Y axis
        data_graph.axisRight.isEnabled = false
        data_graph.axisLeft.granularity = 1f

        data_graph.data = lineData
        data_graph.setPinchZoom(true)
        data_graph.isDoubleTapToZoomEnabled = true
        data_graph.animateX(2000)
        data_graph.invalidate()
    }

    // Callbacks
    override fun onBitcoinMarketPriceRetrieved(bitcoinMarketPriceList: List<BitcoinData>) {
        setGraphData(bitcoinMarketPriceList)
        hideProgress()
    }

    override fun onBitcoinMarketPriceRetrievingError() {
        LoggerUtils.logMessage("BITCOIN DATA", "Error")
        hideProgress()
    }
}
