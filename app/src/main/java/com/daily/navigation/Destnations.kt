package com.daily.navigation

import com.daily.presentation.view.main.navigation.mainRoute
import com.daily.presentation.view.my_theme.navigation.myThemeRoute
import com.daily.presentation.view.profile.navigation.profileRoute

sealed class Destinations(val route: String, val label: String) {
    object Main: Destinations(route = mainRoute, label = "메인")
    object Profile: Destinations(route = profileRoute, label = "프로필보기")
    object MyTheme: Destinations(route = myThemeRoute, label = "테마보기")
}

val destinations = listOf(
    Destinations.Main,
    Destinations.Profile,
    Destinations.MyTheme
)