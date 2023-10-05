package com.daily.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.daily.presentation.view.infomation.navigation.informationScreen
import com.daily.presentation.view.main.navigation.mainScreen
import com.daily.presentation.view.my_theme.navigation.myThemeScreen
import com.daily.presentation.view.profile.navigation.profileScreen
import com.daily.presentation.view.signin.navigation.signinScreen

@Composable
fun DailyNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navController, startDestination = startDestination) {
        signinScreen()
        informationScreen()
        mainScreen()
        profileScreen()
        myThemeScreen()
    }
}
