package com.example.myweatherapp.mvp.view

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweatherapp.R
import com.example.myweatherapp.adapter.ItemClicked
import com.example.myweatherapp.adapter.WeatherAdapter
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.databinding.ActivityMainBinding
import com.example.myweatherapp.fragment.WeatherFragmentDetail
import com.example.myweatherapp.mvp.contract.MyWeatherAppContract

class MyWeatherAppView(activity: Activity, private var binding: ActivityMainBinding) :
    ActivityView(activity), MyWeatherAppContract.MyWeatherAppView {

    override fun showData(weatherFiltered: List<DaysWeather>, item: ItemClicked) {
        binding.RecyclerWeather.layoutManager = LinearLayoutManager(context)
        binding.RecyclerWeather.adapter = WeatherAdapter(weatherFiltered, item)
    }


    override fun showError() {
        Toast.makeText(context, R.string.conection_not_established, Toast.LENGTH_SHORT).show()
    }

    override fun showFragmentDataDetails(date: String, weather: List<DaysWeather>) {
        WeatherFragmentDetail.newInstance(date, weather as ArrayList<DaysWeather>)
            .show(
                (context as FragmentActivity).supportFragmentManager,
                context?.getString(R.string.weather_fragment_more_info)
            )
    }
    override fun showLoading() {
        binding.loadingBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.loadingBar.visibility = View.GONE
    }

}
