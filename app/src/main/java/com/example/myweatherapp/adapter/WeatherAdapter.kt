package com.example.myweatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myweatherapp.R
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.databinding.WeatherFragBinding

class WeatherAdapter (private val weather: List<DaysWeather>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.weather_frag, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weather[position])
    }

    override fun getItemCount() = weather.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = WeatherFragBinding.bind(itemView)

        fun bind(weatherItem: DaysWeather) {
            binding.apply {
                actualTemp.text = "${weatherItem.temperature.temp}${itemView.context?.getString(R.string.celsius)}"
                tempMax.text = "${weatherItem.temperature.tempMax}${itemView.context?.getString(R.string.celsius)}"
                tempMin.text = "${weatherItem.temperature.tempMin}${itemView.context?.getString(R.string.celsius)}"
                realFeel.text =
                    "${itemView.context?.getString(R.string.real_feel)}${weatherItem.temperature.feelsLike}${itemView.context?.getString(R.string.celsius)}"
                date.text = weatherItem.date
                Glide.with(itemView.context)
                    .load("$URL${weatherItem.weatherDescription.first().icon}$FORMAT")
                    .into(iconWeather)
            }
        }
    }

    companion object {
        private const val URL = "https://openweathermap.org/img/wn/"
        private const val FORMAT = "@2x.png"
    }
}
