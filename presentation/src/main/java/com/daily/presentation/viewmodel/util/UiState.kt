package com.daily.presentation.viewmodel.util

sealed interface UiState<out T> {
    data object Loading: UiState<Nothing>
    data class Success<out T>(val data: T? = null) : UiState<T>
    data class Error(val message: String? = null): UiState<Nothing>
}
