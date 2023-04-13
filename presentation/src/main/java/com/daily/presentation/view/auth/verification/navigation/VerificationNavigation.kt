package com.daily.presentation.view.auth.verification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.daily.presentation.view.auth.verification.VerificationScreen

const val verificationRoute = "verification_route"

fun NavController.navigateToVerification(email: String, type: String) {
    this.navigate("$verificationRoute/$email/$type") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.verificationScreen(
    navigateToPrevious: () -> Unit,
    navigateToNext: (String) -> Unit
) {
    composable(
        route = "$verificationRoute/{email}/{type}",
        arguments = listOf(
            navArgument("email") { nullable = false },
            navArgument("type") { nullable = false }
        )
    ) { backStackEntry ->
        VerificationScreen(
            email = backStackEntry.arguments?.getString("email"),
            type = backStackEntry.arguments?.getString("type"),
            navigateToPrevious = navigateToPrevious,
            navigateToNext = navigateToNext
        )
    }
}