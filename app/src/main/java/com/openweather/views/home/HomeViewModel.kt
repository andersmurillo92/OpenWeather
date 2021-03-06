package com.openweather.views.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openweather.data.model.ForecastModel
import com.openweather.domain.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val weatherUseCase: WeatherUseCase): ViewModel() {

    companion object {
        private const val TAG = "HomeViewModel"
    }

    val isLoading = MutableLiveData<Boolean>()
    val forecast = MutableLiveData<ForecastModel?>()

    fun onCreate(){
        getForecast()
    }

    private fun getForecast(){
        viewModelScope.launch {
            try {
                isLoading.value = true

                val result: ForecastModel? = weatherUseCase()
                forecast.value = result
                isLoading.value = false
            } catch (e: Exception){
                Log.e(TAG, "Exception $e")
            }
        }
    }
}