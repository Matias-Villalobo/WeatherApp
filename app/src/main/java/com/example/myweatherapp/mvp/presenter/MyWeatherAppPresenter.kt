package com.example.myweatherapp.mvp.presenter

import com.example.myweatherapp.mvp.contract.MyWeatherAppContract

class MyWeatherAppPresenter(
    private val model: MyWeatherAppContract.MyWeatherAppModel,
    private val view: MyWeatherAppContract.MyWeatherAppView
) :
    MyWeatherAppContract.MyWeatherAppPresenter {

    override fun getWeatherForecast() {
        view.showData()
        model.getData()
    }

}
