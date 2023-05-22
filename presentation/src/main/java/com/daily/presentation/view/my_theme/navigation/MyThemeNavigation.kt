package com.daily.presentation.view.my_theme.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.my_theme.MyThemeScreen

const val myThemeRoute = "my_theme_route"

fun NavController.navigateToMyTheme() {
    this.navigate(myThemeRoute)
}

fun NavGraphBuilder.myThemeScreen() {
    composable(myThemeRoute) {
        MyThemeScreen()
    }
}