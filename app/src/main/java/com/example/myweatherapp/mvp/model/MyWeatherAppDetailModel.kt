package com.example.myweatherapp.mvp.model

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.mvp.contract.MyWeatherAppDetailContract
import com.example.myweatherapp.utils.daysFormat
import com.example.myweatherapp.utils.formatJson

class MyWeatherAppDetailModel() : MyWeatherAppDetailContract.Model {

    override fun getDataOnlyOneDay(forecasts: List<DaysWeather>, date: String): List<DaysWeather> =
        forecasts.filter { it.date.contains(daysFormat.format(formatJson.parse(date))) }
}
