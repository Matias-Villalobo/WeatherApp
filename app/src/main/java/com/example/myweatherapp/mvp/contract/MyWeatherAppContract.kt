package com.example.myweatherapp.mvp.contract

import com.example.myweatherapp.data.service.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface MyWeatherAppContract {

    interface MyWeatherAppModel {
        fun getData(city: String): Observable<WeatherResponse>
    }

    interface MyWeatherAppView {
        fun showData(data:WeatherResponse)
    }

    interface MyWeatherAppPresenter {
        fun getWeatherForecast()
    }
}
