package com.daily.presentation.viewmodel.auth

import com.daily.presentation.viewmodel.util.ExceptionType

sealed interface AuthUiState {
    object Success : AuthUiState
    data class Error(val exception: ExceptionType) : AuthUiState
    object Loading : AuthUiState
}
