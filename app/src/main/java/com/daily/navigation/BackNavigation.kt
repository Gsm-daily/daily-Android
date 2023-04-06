package com.daily.navigation

import androidx.navigation.NavController

fun NavController.navigateToPrevious() {
    val previous = this.previousBackStackEntry?.destination?.route

    if (previous != null) this.popBackStack()
}