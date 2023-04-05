package com.daily.presentation.view.auth.verification.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.auth.verification.VerificationScreen

const val verificationRoute = "verification_route"

fun NavController.navigateToVerification(email: String) {
    this.navigate("$verificationRoute/$email")
}

fun NavGraphBuilder.verificationScreen(
    navigateToPrevious: () -> Unit,
    navigateToSignUp: (String) -> Unit
) {
    composable("$verificationRoute/{email}") {
        VerificationScreen(
            navigateToPrevious = navigateToPrevious,
            navigateToSignUp = navigateToSignUp
        )
    }
}