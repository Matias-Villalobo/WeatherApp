package com.example.myweatherapp.data.service.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list") val list: List<WeatherDataResponse>
)
