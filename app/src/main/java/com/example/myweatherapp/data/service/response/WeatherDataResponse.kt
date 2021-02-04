package com.example.myweatherapp.data.service.response

import com.google.gson.annotations.SerializedName

data class WeatherDataResponse(
    @SerializedName("dt_txt") val date: String,
    @SerializedName("main") val main: WeatherTemperatureResponse,
    @SerializedName("weather") val weatherFullDescription: List<WeatherFullDescriptionResponse>
)
