package com.example.myweatherapp.mvp.model

import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.data.service.WeatherService
import com.example.myweatherapp.mvp.contract.MyWeatherAppContract
import io.reactivex.rxjava3.core.Observable

class MyWeatherAppModel(private val weatherService: WeatherService) :
    MyWeatherAppContract.MyWeatherAppModel {

    override fun getData(city: String): Observable <List<DaysWeather>> =
        weatherService.getWeekWeather(city)
}
