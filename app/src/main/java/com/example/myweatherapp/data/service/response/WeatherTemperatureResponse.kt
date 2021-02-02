package com.example.myweatherapp.data.service.response

import com.google.gson.annotations.SerializedName

data class WeatherTemperatureResponse(
    @SerializedName("temp")val temp: Double,
    @SerializedName("temp_max") val tempMax: Double,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("feels_like") val feelsLike: Double,
)
