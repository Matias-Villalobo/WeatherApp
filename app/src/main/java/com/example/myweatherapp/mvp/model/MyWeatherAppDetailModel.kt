package com.example.myweatherapp.mvp.model

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.data.mapper.daysFormat
import com.example.myweatherapp.data.mapper.formatJson
import com.example.myweatherapp.mvp.contract.MyWeatherAppDetailContract

class MyWeatherAppDetailModel() : MyWeatherAppDetailContract.Model {

    override fun getDataOnlyOneDay(forecasts: List<DaysWeather>, date: String): List<DaysWeather> =
        forecasts.filter { it.date.contains(daysFormat.format(formatJson.parse(date))) }

}

