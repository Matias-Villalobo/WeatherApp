package com.example.myweatherapp.data.entity

data class Data(
    val date: String,
    val temperature: Temperature,
    val weatherDescription: List<WeatherDescription>
)

