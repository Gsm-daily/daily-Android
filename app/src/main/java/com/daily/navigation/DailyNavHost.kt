package com.daily.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.daily.presentation.view.auth.forgot_password.navigation.forgotPassword
import com.daily.presentation.view.auth.forgot_password.navigation.forgotPasswordScreen
import com.daily.presentation.view.auth.forgot_password.navigation.navigateToForgotPassword
import com.daily.presentation.view.auth.intro.navigation.introScreen
import com.daily.presentation.view.auth.login.navigation.loginScreen
import com.daily.presentation.view.auth.login.navigation.navigateToLogin
import com.daily.presentation.view.auth.select_theme.navigation.navigateToSelectTheme
import com.daily.presentation.view.auth.select_theme.navigation.selectThemeScreen
import com.daily.presentation.view.auth.signup.navigation.navigateToSignUp
import com.daily.presentation.view.auth.signup.navigation.signUpRoute
import com.daily.presentation.view.auth.signup.navigation.signUpScreen
import com.daily.presentation.view.auth.verification.navigation.navigateToVerification
import com.daily.presentation.view.auth.verification.navigation.verificationScreen

@Composable
fun DailyNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navController, startDestination = startDestination) {
        introScreen(
            navigateToLogin = { navController.navigateToLogin() },
            navigateToSignUp = { navController.navigateToSignUp() }
        )
        loginScreen(
            navigateToPrevious = { navController.navigateToPrevious() },
            navigateToSignUp = { navController.navigateToSignUp() },
            navigateToForgotPassword = { navController.navigateToForgotPassword() }
        )
        signUpScreen(
            navigateToPrevious = { navController.navigateToPrevious() },
            navigateToLogin = { navController.navigateToLogin() },
            navigateToVerification = { navController.navigateToVerification(it) },
            navigateToSelectTheme = { navController.navigateToSelectTheme() }
        )
        verificationScreen(
            navigateToPrevious = { navController.navigateToPrevious() },
            navigateToNext = {
                when (navController.previousBackStackEntry?.destination?.route) {
                    "$signUpRoute?email={email}" -> navController.navigateToSignUp(it)
                    "$forgotPassword?email={email}" -> navController.navigateToForgotPassword(it)
                }
            }
        )
        forgotPasswordScreen(
            navigateToPrevious = { navController.navigateToPrevious() },
            navigateToLogin = { navController.navigateToLogin() },
            navigateToVerification = { navController.navigateToVerification(it) }
        )
        selectThemeScreen(
            navigateToPrevious = { navController.navigateToPrevious() }
        )
    }
}