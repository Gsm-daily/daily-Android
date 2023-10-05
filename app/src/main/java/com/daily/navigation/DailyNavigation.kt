package com.daily.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

fun NavController.navigateToDestination(route: String) {
    val startRoute = this.graph.findStartDestination().id

    this.navigate(route) {
        popUpTo(startRoute) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
