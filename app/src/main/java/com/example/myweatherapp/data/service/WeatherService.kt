package com.example.myweatherapp.data.service

import com.example.myweatherapp.BuildConfig
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.data.mapper.mapToWeatherDataList
import com.example.myweatherapp.data.service.request.generator.WeatherRequestGenerator
import com.example.myweatherapp.data.service.api.WeatherApi
import io.reactivex.rxjava3.core.Observable

class WeatherService {

    private val api = WeatherRequestGenerator()

    fun getWeekWeather(cityWeather: String): Observable<List<DaysWeather>> {
        return Observable.create { subscriber ->
            val callResponse =
                api.createService(WeatherApi::class.java)
                    .getForecast(cityWeather, BuildConfig.APPID, UNITS)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.list?.mapToWeatherDataList()?.let { subscriber.onNext(it) }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        const val UNITS = "metric"
    }
}
