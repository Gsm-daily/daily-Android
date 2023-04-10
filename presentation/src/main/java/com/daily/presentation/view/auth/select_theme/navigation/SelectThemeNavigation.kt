package com.daily.presentation.view.auth.select_theme.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.auth.intro.navigation.introRoute
import com.daily.presentation.view.auth.select_theme.SelectThemeScreen

const val selectThemeRoute = "select_theme"

fun NavController.navigateToSelectTheme() {
    this.navigate(selectThemeRoute) {
        popUpTo(introRoute) { inclusive = false }
    }
}

fun NavGraphBuilder.selectThemeScreen(navigateToPrevious: () -> Unit) {
    composable(selectThemeRoute) {
        SelectThemeScreen(
            navigateToPrevious = navigateToPrevious
        )
    }
}