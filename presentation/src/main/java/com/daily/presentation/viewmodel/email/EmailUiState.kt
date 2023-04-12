package com.daily.presentation.viewmodel.email

import com.daily.presentation.viewmodel.util.ExceptionType

interface EmailUiState {
    object Success : EmailUiState
    data class Error(val exception: ExceptionType) : EmailUiState
    object Loading : EmailUiState
}