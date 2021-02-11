package com.example.myweatherapp.mvp.model

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.mvp.contract.MyWeatherAppDetailContract
import com.example.myweatherapp.utils.WeatherStringUtils
import java.text.SimpleDateFormat
import java.util.Locale

class MyWeatherAppDetailModel() : MyWeatherAppDetailContract.Model {
    val formatMilitaryTime = SimpleDateFormat(WeatherStringUtils.JSON_MILITARY_TIME_PATTERN, Locale.ENGLISH)
    val formatYearMonthDays = SimpleDateFormat(WeatherStringUtils.JSON_YEAR_MONTHS_DAYS_PATTERN)

    override fun getDataOnlyOneDay(forecasts: List<DaysWeather>, date: String): List<DaysWeather> =
        forecasts.filter { it.date.contains(formatYearMonthDays.format(formatMilitaryTime.parse(date))) }
}
