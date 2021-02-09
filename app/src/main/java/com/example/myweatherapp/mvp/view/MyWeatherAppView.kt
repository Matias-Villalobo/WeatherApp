package com.example.myweatherapp.mvp.view

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweatherapp.R
import com.example.myweatherapp.adapter.WeatherAdapter
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.databinding.ActivityMainBinding
import com.example.myweatherapp.mvp.contract.MyWeatherAppContract

class MyWeatherAppView(activity: Activity, private var binding: ActivityMainBinding) :
    ActivityView(activity), MyWeatherAppContract.MyWeatherAppView {

    override fun showData(data: List<DaysWeather>) {
        binding.RecyclerWeather.layoutManager = LinearLayoutManager(context)
        binding.RecyclerWeather.adapter = WeatherAdapter(data)
    }

    override fun showError() {
        Toast.makeText(context, R.string.conection_not_established, Toast.LENGTH_SHORT).show()
    }
}
