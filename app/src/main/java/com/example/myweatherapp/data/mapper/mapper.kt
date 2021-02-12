package com.example.myweatherapp.data.mapper

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.data.entity.Temperature
import com.example.myweatherapp.data.entity.WeatherDescription
import com.example.myweatherapp.data.service.response.WeatherDataResponse
import com.example.myweatherapp.data.service.response.WeatherFullDescriptionResponse
import com.example.myweatherapp.data.service.response.WeatherTemperatureResponse

private fun WeatherTemperatureResponse.transformMain() =
    Temperature(feelsLike, temp, tempMax, tempMin)

private fun WeatherFullDescriptionResponse.mapToWeatherDescription() =
    WeatherDescription(description, icon, id, main)

private fun List<WeatherFullDescriptionResponse>.transformWeatherDescription(): List<WeatherDescription> =
    this.map { it.mapToWeatherDescription() }

private fun WeatherDataResponse.mapToWeatherData(): DaysWeather = DaysWeather(
    date,
    main.transformMain(),
    weatherFullDescription.transformWeatherDescription()
)

fun List<WeatherDataResponse>.mapToWeatherDataList(): List<DaysWeather> =
    this.map { it.mapToWeatherData() }
