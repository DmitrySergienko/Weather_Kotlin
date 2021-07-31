package ru.ds.weather_kotlin.repository

import ru.ds.weather_kotlin.data.Weather


sealed class AppState {
    data class Success(val weatherData: List<Weather>) : AppState()
    class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}