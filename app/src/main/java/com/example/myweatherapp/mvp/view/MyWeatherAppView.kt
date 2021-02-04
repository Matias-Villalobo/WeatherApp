package com.example.myweatherapp.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.myweatherapp.R
import com.example.myweatherapp.data.entity.Weather
import com.example.myweatherapp.data.service.response.WeatherResponse
import com.example.myweatherapp.databinding.ActivityMainBinding
import com.example.myweatherapp.mvp.contract.MyWeatherAppContract

class MyWeatherAppView(activity: Activity, private var binding: ActivityMainBinding) :
    ActivityView(activity), MyWeatherAppContract.MyWeatherAppView {

    override fun showData(data: Weather) {
        Toast.makeText(context, R.string.conection_established, Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(context, R.string.conection_not_established, Toast.LENGTH_SHORT).show()
    }
}
