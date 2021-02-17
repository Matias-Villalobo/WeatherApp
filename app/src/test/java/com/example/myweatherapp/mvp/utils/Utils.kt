package com.example.myweatherapp.mvp.utils

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.data.entity.Temperature
import com.example.myweatherapp.data.entity.WeatherDescription

object Utils {
    const val DATE_ONE = "2021-02-05 21:00:00"
    const val DATE_TWO = "2021-02-06 03:00:00"
    const val DATE_THREE = "2021-02-06 12:00:00"
    const val NUMBER_TWO = 2
    const val NUMBER_ONE = 1
    const val NUMBER_ZERO = 0
    const val NUMBER_FORTY = 40
    const val CITY = "Tandil"
    val temperature = Temperature(302.82, 305.98, 306.39, 305.98)
    val temperature2 = Temperature(287.5, 290.6, 290.6, 290.49)
    val temperature3 = Temperature(286.3, 291.09, 291.09, 291.09)
    val listWeatherDescription: List<WeatherDescription> = listOf(
        WeatherDescription("clear sky", "01d", 800, "Clear")
    )
    val listWeatherDescription2: List<WeatherDescription> = listOf(
        WeatherDescription("clear sky", "01n", 800, "Clear")
    )
    val weatherData1 = DaysWeather(DATE_ONE, temperature, listWeatherDescription)
    val weatherData2 = DaysWeather(DATE_TWO, temperature2, listWeatherDescription2)
    val weatherData3 = DaysWeather(DATE_THREE, temperature3, listWeatherDescription2)
    val weatherList: List<DaysWeather> = listOf(weatherData1, weatherData2, weatherData3)
    val weatherListEmpty: List<DaysWeather> = listOf()
}
