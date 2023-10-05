package com.daily.presentation.view.signin.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.signin.SignInScreen

const val signinRoute = "signin_route"

fun NavGraphBuilder.signinScreen() {
    composable(signinRoute) {
        SignInScreen()
    }
}
