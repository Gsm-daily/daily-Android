package com.daily.presentation.view.auth.forgot_password.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.daily.presentation.view.auth.forgot_password.ForgotPasswordScreen

const val forgotPassword = "forgot_password"

fun NavController.navigateToForgotPassword(email: String? = null) {
    val route = email?.let { "$forgotPassword?email=$it" } ?: forgotPassword
    val prevRoute = this.currentBackStackEntry?.destination?.route

    this.navigate(route) {
        prevRoute?.let {
            popUpTo(it) {
                inclusive = true
            }
        }
    }
}

fun NavGraphBuilder.forgotPasswordScreen(
    navigateToPrevious: () -> Unit,
    navigateToSignIn: () -> Unit,
    navigateToVerification: (String) -> Unit
) {
    composable(
        route = "$forgotPassword?email={email}",
        arguments = listOf(navArgument("email") { nullable = true })
    ) { backStackEntry ->
        ForgotPasswordScreen(
            email = backStackEntry.arguments?.getString("email"),
            navigateToPrevious = navigateToPrevious,
            navigateToLogin = navigateToSignIn,
            navigateToVerification = navigateToVerification
        )
    }
}