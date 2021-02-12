package com.example.myweatherapp.mvp.view

import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweatherapp.R
import com.example.myweatherapp.adapter.WeatherAdapter
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.databinding.WeatherFragmentInDetailBinding
import com.example.myweatherapp.mvp.contract.MyWeatherAppDetailContract

class MyWeatherAppDetailView(
    fragment: DialogFragment,
    private val binding: WeatherFragmentInDetailBinding
) : MyWeatherAppDetailContract.View,
    FragmentView(fragment) {

    override fun showFragmentData(weatherFiltered: List<DaysWeather>) {
        binding.recyclerViewWeather.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewWeather.adapter = WeatherAdapter(weatherFiltered)
    }

    override fun showFragmentError() {
        Toast.makeText(context, R.string.conection_not_established, Toast.LENGTH_SHORT).show()
    }
}
