package com.daily.daily

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : androidx.activity.ComponentActivity() {
    private var keepSplashOnScreen = true
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition { keepSplashOnScreen }
        Handler(Looper.getMainLooper()).postDelayed({ keepSplashOnScreen = false }, 1500L)

        super.onCreate(savedInstanceState)

        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {

            }
        }
    }
}