package com.daily.presentation.view.auth.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.auth.login.LoginScreen

const val loginRoute = "login_route"

fun NavController.navigateToLogin() {
    this.navigate(loginRoute) {
        popUpTo(loginRoute) {
            inclusive = true
        }
    }
}

fun NavGraphBuilder.loginScreen(
    navigateToPrevious: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToForgotPassword: () -> Unit
) {
    composable(loginRoute) {
        LoginScreen(
            navigateToPrevious = navigateToPrevious,
            navigateToSignUp = navigateToSignUp,
            navigateToForgotPassword = navigateToForgotPassword
        )
    }
}