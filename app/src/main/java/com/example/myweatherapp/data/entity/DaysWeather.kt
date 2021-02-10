package com.example.myweatherapp.data.entity

import java.io.Serializable

data class DaysWeather(
    val date: String,
    val temperature: Temperature,
    val weatherDescription: List<WeatherDescription>
) : Serializable
