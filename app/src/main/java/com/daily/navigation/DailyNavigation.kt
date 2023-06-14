package com.daily.navigation

import androidx.navigation.NavController

fun NavController.navigateToDestination(route: String) {
    this.navigate(route) {
        launchSingleTop = true
    }
}