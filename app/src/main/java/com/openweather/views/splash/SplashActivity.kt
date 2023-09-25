package com.openweather.views.splash

import androidx.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import com.openweather.R
import com.openweather.databinding.ActivitySplashBinding

class SplashActivity: AppCompatActivity() {

    lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        supportActionBar?.hide()
        initializeView()
    }

    private fun initializeView(){
        binding.splashView.visibility = View.VISIBLE

        val mHandler = Handler()
        mHandler.postDelayed({
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                val cx = (binding.splashView.left + binding.splashView.right) / 2
                val cy = (binding.splashView.top + binding.splashView.bottom) / 2

                // get the final radius for the clipping circle
                val finalRadius = Math.max(binding.splashView.width, binding.splashView.height).toFloat()

                // create the animator for this imageInstruction (the start radius is zero)
                val anim = ViewAnimationUtils.createCircularReveal(binding.splashView, cx, cy, 0f, finalRadius)
                anim.interpolator = AccelerateInterpolator()
                anim.duration = 1250

                // make the imageInstruction visible and start the animation
                anim.start()

            } else {
                binding.splashView.visibility = View.VISIBLE
            }
        }, 50)

        val mHandler1 = Handler()
        mHandler1.postDelayed({
            // TODO("Go to min activity")
        }, 1750)
    }
}