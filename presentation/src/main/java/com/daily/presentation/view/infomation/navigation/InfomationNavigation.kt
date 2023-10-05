package com.daily.presentation.view.infomation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.infomation.InformationScreen

const val informationRoute = "information_route"

fun NavController.navigateToInformation() {
    this.navigate(informationRoute)
}

fun NavGraphBuilder.informationScreen() {
    composable(informationRoute) {
        InformationScreen()
    }
}
