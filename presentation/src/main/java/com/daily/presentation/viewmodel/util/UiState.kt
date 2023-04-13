package com.daily.presentation.viewmodel.util

sealed interface UiState {
    object Loading: UiState
    object Success: UiState
    object BadRequest: UiState
    object Unauthorized: UiState
    object Forbidden: UiState
    object NotFound: UiState
    object Conflict: UiState
    object Server: UiState
    object Unknown: UiState
}