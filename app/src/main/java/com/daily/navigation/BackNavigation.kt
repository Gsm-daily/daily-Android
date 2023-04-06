package com.daily.navigation

import androidx.navigation.NavController

fun NavController.navigateToPrevious() {
    val previous = this.previousBackStackEntry?.destination?.route

    previous?.let { this.navigate(it) }
}