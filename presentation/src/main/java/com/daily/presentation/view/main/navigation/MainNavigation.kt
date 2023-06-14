package com.daily.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.main.MainScreen

const val mainRoute = "main_route"

fun NavController.navigateToMain() {
    val startRoute = this.graph.startDestinationRoute

    this.navigate(mainRoute) {
        startRoute?.let {
            popUpTo(it) {
                inclusive = true
            }
        }
    }
}

fun NavGraphBuilder.mainScreen() {
    composable(mainRoute) {
        MainScreen()
    }
}