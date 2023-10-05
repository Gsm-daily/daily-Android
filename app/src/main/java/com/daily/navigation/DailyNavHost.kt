package com.daily.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.daily.presentation.view.select_theme.navigation.selectThemeScreen
import com.daily.presentation.view.main.navigation.mainScreen
import com.daily.presentation.view.main.navigation.navigateToMain
import com.daily.presentation.view.my_theme.navigation.myThemeScreen
import com.daily.presentation.view.profile.navigation.profileScreen

@Composable
fun DailyNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navController, startDestination = startDestination) {
//        TODO: 카카오 로그인 페이지 퍼블리싱 후 navigation 설정
//        introScreen(
//            navigateToSignIn = { navController.navigateToSignIn() },
//            navigateToSignUp = { navController.navigateToSignUp() }
//        )
        selectThemeScreen(
            navigateToPrevious = { navController.navigateToPrevious() },
            navigateToMain = { navController.navigateToMain() }
        )
        mainScreen()
        profileScreen()
        myThemeScreen()
    }
}
