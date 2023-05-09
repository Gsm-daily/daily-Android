package com.daily.presentation.viewmodel.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.ChangePasswordRequest
import com.daily.domain.usecase.ChangePasswordUseCase
import com.daily.domain.usecase.ChoiceThemeUseCase
import com.daily.presentation.viewmodel.util.UiState
import com.daily.presentation.viewmodel.util.exceptionHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val choiceThemeUseCase: ChoiceThemeUseCase,
    private val changePasswordUseCase: ChangePasswordUseCase,
) : ViewModel() {
    private val _choiceThemeUiState = MutableStateFlow<UiState>(UiState.Loading)
    val choiceThemeUiState = _choiceThemeUiState.asStateFlow()

    private val _changePasswordUiState = MutableStateFlow<UiState>(UiState.Loading)
    val changePasswordUiState = _changePasswordUiState.asStateFlow()

    fun choiceTheme(theme: String) {
        viewModelScope.launch {
            choiceThemeUseCase(theme)
                .onSuccess {
                    _choiceThemeUiState.value = UiState.Success
                }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = { _choiceThemeUiState.value = UiState.BadRequest },
                        unauthorizedAction = { _choiceThemeUiState.value = UiState.Unauthorized },
                        forbiddenAction = { _choiceThemeUiState.value = UiState.Forbidden },
                        notFoundAction = { _choiceThemeUiState.value = UiState.NotFound },
                        conflictAction = { _choiceThemeUiState.value = UiState.Conflict },
                        unknownAction = { _choiceThemeUiState.value = UiState.Unknown }
                    )
                }
        }
    }

    fun changePassword(email: String, newPassword: String) {
        viewModelScope.launch {
            changePasswordUseCase(
                ChangePasswordRequest(
                    email = email,
                    newPassword = newPassword
                )
            )
                .onSuccess {
                    _changePasswordUiState.value = UiState.Success
                }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = { _changePasswordUiState.value = UiState.BadRequest },
                        notFoundAction = { _changePasswordUiState.value = UiState.NotFound },
                        unknownAction = { _changePasswordUiState.value = UiState.Unknown }
                    )
                }
        }
    }
}