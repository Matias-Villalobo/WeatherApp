package com.example.myweatherapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myweatherapp.R
import com.example.myweatherapp.data.entity.DaysWeather
import com.example.myweatherapp.databinding.WeatherFragmentBinding
import com.example.myweatherapp.utils.WeatherDatesUtils.formatSimpleDate
import com.example.myweatherapp.utils.WeatherDatesUtils.formatMilitaryTime
import com.example.myweatherapp.utils.WeatherDatesUtils.formatHoursMinutes

interface ItemClicked {
    fun weatherClicked(date: String)
}

class WeatherAdapter(
    private val weather: List<DaysWeather>,
    private val item: ItemClicked? = null
) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.weather_fragment, parent, false),
            item
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = weather[position]
        holder.bind(item)
    }

    override fun getItemCount() = weather.size

    class ViewHolder(itemView: View, private val item: ItemClicked?) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = WeatherFragmentBinding.bind(itemView)

        fun bind(weatherItem: DaysWeather) {
            binding.apply {
                actualTemp.text =
                    "${weatherItem.temperature.temp}${itemView.context?.getString(R.string.celsius)}"
                tempMax.text =
                    "${weatherItem.temperature.tempMax}${itemView.context?.getString(R.string.celsius)}"
                tempMin.text =
                    "${weatherItem.temperature.tempMin}${itemView.context?.getString(R.string.celsius)}"
                realFeel.text =
                    "${itemView.context?.getString(R.string.real_feel)}${weatherItem.temperature.feelsLike}${
                        itemView.context?.getString(
                            R.string.celsius
                        )
                    }"
                if (item == null) {
                    date.text =
                        formatHoursMinutes.format(formatMilitaryTime.parse(weatherItem.date))
                } else {
                    date.text = formatSimpleDate.format(formatMilitaryTime.parse(weatherItem.date))
                }
                Glide.with(itemView.context)
                    .load("$URL${weatherItem.weatherDescription.first().icon}$FORMAT")
                    .into(iconWeather)
                cardviewWeatherFrag.setOnClickListener { item?.weatherClicked(weatherItem.date) }
            }
        }
    }

    companion object {
        private const val URL = "http://openweathermap.org/img/wn/"
        private const val FORMAT = "@2x.png"
    }
}
