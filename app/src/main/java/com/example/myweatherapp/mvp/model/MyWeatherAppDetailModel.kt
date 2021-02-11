package com.example.myweatherapp.mvp.model

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.mvp.contract.MyWeatherAppDetailContract
import com.example.myweatherapp.utils.WeatherDatesUtils.formatYearMonthDays
import com.example.myweatherapp.utils.WeatherDatesUtils.formatMilitaryTime

class MyWeatherAppDetailModel() : MyWeatherAppDetailContract.Model {
    override fun getDataOnlyOneDay(forecasts: List<DaysWeather>, date: String): List<DaysWeather> =
        forecasts.filter { it.date.contains(formatYearMonthDays.format(formatMilitaryTime.parse(date))) }
}
