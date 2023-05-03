package com.daily.presentation.view.auth.signin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.auth.signin.SignInScreen

const val signInRoute = "signin_route"

fun NavController.navigateToSignIn() {
    this.navigate(signInRoute) {
        popUpTo(signInRoute) {
            inclusive = true
        }
    }
}

fun NavGraphBuilder.signInScreen(
    navigateToPrevious: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToForgotPassword: () -> Unit
) {
    composable(signInRoute) {
        SignInScreen(
            navigateToPrevious = navigateToPrevious,
            navigateToSignUp = navigateToSignUp,
            navigateToForgotPassword = navigateToForgotPassword
        )
    }
}