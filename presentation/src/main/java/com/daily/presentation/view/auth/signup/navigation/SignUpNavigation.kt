package com.daily.presentation.view.auth.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.daily.presentation.view.auth.signup.SignUpScreen

const val signUpRoute = "signup_route"

fun NavController.navigateToSignUp(email: String? = null) {
    val route = email?.let { "$signUpRoute?email=$it" } ?: signUpRoute
    this.navigate(route)
}

fun NavGraphBuilder.signUpScreen(
    navigateToPrevious: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToVerification: (String) -> Unit
) {
    composable(
        route = "$signUpRoute?email={email}",
        arguments = listOf(navArgument("email") { nullable = true })
    ) { backStackEntry ->
        SignUpScreen(
            email = backStackEntry.arguments?.getString("email"),
            navigateToPrevious = navigateToPrevious,
            navigateToLogin = navigateToLogin,
            navigateToVerification = navigateToVerification
        )
    }
}