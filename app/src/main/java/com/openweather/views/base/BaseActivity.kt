package com.openweather.views.base

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    fun isOnline(): Boolean {
        var result = false
        val connMgr = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected)
            result = true
        return result
    }
}