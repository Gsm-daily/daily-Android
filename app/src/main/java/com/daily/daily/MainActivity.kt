package com.daily.daily

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.daily.designsystem.component.navbar.DailyNavBar
import com.daily.designsystem.component.navbar.DailyNavItem
import com.daily.designsystem.theme.IcNote
import com.daily.designsystem.theme.IcPerson
import com.daily.designsystem.theme.IcPicture
import com.daily.navigation.DailyNavHost
import com.daily.navigation.Destinations
import com.daily.navigation.destinations
import com.daily.navigation.navigateToDestination
import com.daily.presentation.view.main.navigation.mainRoute
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
            val navController = rememberNavController()

            Surface(modifier = Modifier.fillMaxSize()) {
                Scaffold(
                    bottomBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route
                        val showBottomBar = currentRoute in destinations.map { it.route }

                        if (showBottomBar) {
                            DailyNavBar {
                                destinations.forEach { destination ->
                                    val selected = currentRoute?.let { destination.route == it } ?: false
                                    Log.d("currentRoute", currentRoute.toString())

                                    DailyNavItem(
                                        label = destination.label,
                                        selected = selected,
                                        icon = {
                                            when (destination) {
                                                is Destinations.Main -> {
                                                    IcNote(
                                                        contentDescription = "메인",
                                                        tint = LocalContentColor.current
                                                    )
                                                }

                                                is Destinations.Profile -> {
                                                    IcPerson(
                                                        contentDescription = "프로필보기",
                                                        tint = LocalContentColor.current
                                                    )
                                                }

                                                is Destinations.MyTheme -> {
                                                    IcPicture(
                                                        contentDescription = "테마보기",
                                                        tint = LocalContentColor.current
                                                    )
                                                }
                                            }
                                        },
                                        onClick = { navController.navigateToDestination(destination.route) }
                                    )
                                }
                            }
                        }
                    },
                    contentWindowInsets = WindowInsets(0.dp)
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        DailyNavHost(navController = navController, startDestination = mainRoute)
                    }
                }
            }
        }
    }
}
