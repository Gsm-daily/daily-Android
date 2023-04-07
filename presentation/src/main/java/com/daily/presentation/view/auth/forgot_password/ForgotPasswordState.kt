package com.daily.presentation.view.auth.forgot_password

sealed interface ForgotPasswordState {
    object EmailInput: ForgotPasswordState
    object PasswordInput: ForgotPasswordState
}