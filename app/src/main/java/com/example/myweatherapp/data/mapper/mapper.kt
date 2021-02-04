package com.example.myweatherapp.data.mapper

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.data.entity.Temperature
import com.example.myweatherapp.data.entity.Weather
import com.example.myweatherapp.data.entity.WeatherDescription
import com.example.myweatherapp.data.service.response.WeatherDataResponse
import com.example.myweatherapp.data.service.response.WeatherFullDescriptionResponse
import com.example.myweatherapp.data.service.response.WeatherResponse
import com.example.myweatherapp.data.service.response.WeatherTemperatureResponse

fun WeatherResponse.transform(): Weather = Weather(this.list.transformData())

fun List<WeatherDataResponse>.transformData(): List<DaysWeather> = this.map {
    it.mapToDaysWeather()
}

fun WeatherDataResponse.mapToDaysWeather(): DaysWeather = DaysWeather(
    this.date,
    this.main.transformMain(),
    (this.weatherFullDescription).transformWeatherDescription()
)

fun WeatherTemperatureResponse.transformMain(): Temperature =
    Temperature(this.feelsLike, this.temp, this.tempMax, this.tempMin)

fun WeatherFullDescriptionResponse.mapToweather(): WeatherDescription = WeatherDescription(
    this.description, this.icon, this.id, this.main
)

fun List<WeatherFullDescriptionResponse>.transformWeatherDescription(): List<WeatherDescription> =
    this.map {
        it.mapToweather()
    }
