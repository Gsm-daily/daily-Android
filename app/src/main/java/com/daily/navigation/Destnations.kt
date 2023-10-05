package com.daily.navigation

import com.daily.presentation.view.main.navigation.mainRoute
import com.daily.presentation.view.my_theme.navigation.myThemeRoute
import com.daily.presentation.view.profile.navigation.profileRoute

enum class Destinations(
    val label: String,
    val route: String
) {
    Main(label = "메인", route = mainRoute),
    Profile(label = "프로필보기", route = profileRoute),
    MyTheme(label = "테마보기", route = myThemeRoute)
}
