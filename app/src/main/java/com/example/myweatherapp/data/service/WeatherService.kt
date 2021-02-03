package com.example.myweatherapp.data.service

import android.util.Log
import com.example.myweatherapp.BuildConfig
import com.example.myweatherapp.data.entity.Weather
import com.example.myweatherapp.data.mapper.WeatherMapper
import com.example.myweatherapp.data.service.request.generator.WeatherRequestGenerator
import com.example.myweatherapp.data.service.api.WeatherApi
import com.example.myweatherapp.data.service.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

class WeatherService {

    private val api = WeatherRequestGenerator()
    private val mapper = WeatherMapper()

    fun getWeekWeather(cityWeather: String): Observable<Weather> {
        return Observable.create { subscriber ->
            val callResponse =
                api.createService(WeatherApi::class.java)
                    .getForecast(cityWeather, BuildConfig.APPID, UNITS)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                Log.d(TAG, response.body().toString())
                (response.body()?.let { subscriber.onNext(mapper.transform(it)) })
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val UNITS = "metric"
        private const val TAG = "WeatherResponse"
    }
}
