package com.example.myweatherapp.data.service.response

import com.google.gson.annotations.SerializedName

data class WeatherFullDescriptionResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)
