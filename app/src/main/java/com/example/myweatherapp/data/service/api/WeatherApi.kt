package com.example.myweatherapp.data.service.api

import com.example.myweatherapp.data.service.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    fun getForecast(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ): Call<WeatherResponse>

}
