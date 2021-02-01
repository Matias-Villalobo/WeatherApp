package com.example.myweatherapp.data.service


import com.example.myweatherapp.data.request.generator.WeatherRequestGenerator
import com.example.myweatherapp.data.service.api.WeatherApi
import java.util.*
import com.example.myweatherapp.data.service.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

class WeatherService {

    private val api = WeatherRequestGenerator()

    fun getWeekWeather (cityWeather : String) : Observable <WeatherResponse>{
        return Observable.create {subscriber ->
            val callResponse = api.createService(WeatherApi::class.java).getForecast(cityWeather, APPID, UNITS)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let { subscriber.onNext(it) }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val UNITS = "metric"
        private const val APPID = "16ed760ab156214729d1e276a01e9653"
    }
}
