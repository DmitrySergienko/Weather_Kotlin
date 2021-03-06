package ru.ds.weather_kotlin.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.ds.weather_kotlin.data.Weather
import ru.ds.weather_kotlin.databinding.MainRecyclerItemBinding



class MainFragmentAdapter :
        RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var weatherData: List<Weather> = listOf()
    private var onItemViewClickListener: MainFragment.OnItemViewClickListener? = null

    fun setOnItemViewClickListener(onItemViewClickListener: MainFragment.OnItemViewClickListener){
        this.onItemViewClickListener = onItemViewClickListener
    }

    fun removeOnItemViewClickListener(){
        onItemViewClickListener = null
    }

    fun setWeather(data: List<Weather>) {
        weatherData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = MainRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(weatherData[position])
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    inner class MainViewHolder(val binding: MainRecyclerItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather) {
            binding.mainFragmentRecyclerItemTextView.text = weather.city.city
            binding.root.setOnClickListener {
                onItemViewClickListener?.onItemViewClick(weather)
            }
        }
    }
}