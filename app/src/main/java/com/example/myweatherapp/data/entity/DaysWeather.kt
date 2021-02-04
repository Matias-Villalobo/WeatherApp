package com.example.myweatherapp.data.entity

data class DaysWeather(
    val date: String,
    val temperature: Temperature,
    val weatherDescription: List<WeatherDescription>
)

