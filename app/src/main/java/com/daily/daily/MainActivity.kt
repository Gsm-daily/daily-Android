package com.daily.daily

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.daily.navigation.DailyNavHost
import com.daily.presentation.view.auth.intro.navigation.introRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : androidx.activity.ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        window.setTransparentStatusBar()

        splashScreen.setOnExitAnimationListener { splashScreenView ->
            val fadeIn = ObjectAnimator.ofFloat(
                splashScreenView,
                View.ALPHA,
                0.1f,
                0f
            )
            with(fadeIn) {
                duration = 50L
                doOnEnd { splashScreenView.remove() }
                start()
            }
        }

        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                val navController = rememberNavController()

                DailyNavHost(navController = navController, startDestination = introRoute)
            }
        }
    }
}