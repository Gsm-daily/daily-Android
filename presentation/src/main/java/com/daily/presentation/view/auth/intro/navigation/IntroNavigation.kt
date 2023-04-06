package com.daily.presentation.view.auth.intro.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.auth.intro.IntroScreen

const val introRoute = "intro_route"

fun NavGraphBuilder.introScreen(
    navigateToLogin: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    composable(introRoute) {
        IntroScreen(
            navigateToLogin = navigateToLogin,
            navigateToSignUp = navigateToSignUp
        )
    }
}