package com.example.myweatherapp.mvp.presenter

import com.example.myweatherapp.mvp.contract.MyWeatherAppContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MyWeatherAppPresenter(
    private val model: MyWeatherAppContract.MyWeatherAppModel,
    private val view: MyWeatherAppContract.MyWeatherAppView
) :
    MyWeatherAppContract.MyWeatherAppPresenter {

    override fun getWeatherForecast() {
        model.getData(CITY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data -> view.showData(data) },{view.showError()})
    }
    companion object {
        private const val CITY = "Tandil"
    }

}
