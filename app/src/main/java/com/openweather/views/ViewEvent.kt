package com.openweather.views

sealed class ViewEvent{
    class Error (val errorMessage: String): ViewEvent()
    class Success(val successMessage: String): ViewEvent()
}
