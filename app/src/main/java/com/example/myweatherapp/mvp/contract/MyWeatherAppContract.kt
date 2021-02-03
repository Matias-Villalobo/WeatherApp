package com.example.myweatherapp.mvp.contract

import com.example.myweatherapp.data.entity.Weather
import com.example.myweatherapp.data.service.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface MyWeatherAppContract {

    interface MyWeatherAppModel {
        fun getData(city: String): Observable<Weather>
    }

    interface MyWeatherAppView {
        fun showData(data: Weather)
        fun showError()
    }

    interface MyWeatherAppPresenter {
        fun getWeatherForecast()
    }
}
