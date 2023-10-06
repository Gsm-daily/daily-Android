package com.daily.presentation.viewmodel.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.auth.request.ChangePasswordRequest
import com.daily.domain.model.account.response.ThemeCountResponse
import com.daily.domain.model.account.response.ThemeResponse
import com.daily.domain.usecase.auth.ChangePasswordUseCase
import com.daily.domain.usecase.account.ChoiceThemeUseCase
import com.daily.domain.usecase.account.GetThemeDiaryCountUseCase
import com.daily.domain.usecase.account.GetThemeUseCase
import com.daily.presentation.viewmodel.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val choiceThemeUseCase: ChoiceThemeUseCase,
    private val changePasswordUseCase: ChangePasswordUseCase,
    private val getThemeUseCase: GetThemeUseCase,
    private val getThemeDiaryCountUseCase: GetThemeDiaryCountUseCase
) : ViewModel() {
    private val _choiceThemeUiState = MutableStateFlow<UiState<Nothing?>>(UiState.Loading)
    val choiceThemeUiState = _choiceThemeUiState.asStateFlow()

    private val _changePasswordUiState = MutableStateFlow<UiState<Nothing>>(UiState.Loading)
    val changePasswordUiState = _changePasswordUiState.asStateFlow()

    private val _myThemeUiState = MutableStateFlow<UiState<ThemeResponse>>(UiState.Loading)
    val myThemeUiState = _myThemeUiState.asStateFlow()

    private val _countUiState = MutableStateFlow<UiState<ThemeCountResponse>>(UiState.Loading)
    val countUiState = _countUiState.asStateFlow()

    fun choiceTheme(theme: String) {
        viewModelScope.launch {
            choiceThemeUseCase(theme)
                .onSuccess {
                    _choiceThemeUiState.value = UiState.Success()
                }.onFailure {
                    _choiceThemeUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun changePassword(email: String, newPassword: String) {
        viewModelScope.launch {
            changePasswordUseCase(
                ChangePasswordRequest(email = email, newPassword = newPassword)
            )
                .onSuccess {
                    _changePasswordUiState.value = UiState.Success()
                }.onFailure {
                    _changePasswordUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun getTheme() {
        viewModelScope.launch {
            getThemeUseCase()
                .onSuccess {
                    _myThemeUiState.value = UiState.Success(it)
                }.onFailure {
                    _myThemeUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun getThemeDiaryCount(theme: String) {
        viewModelScope.launch {
            getThemeDiaryCountUseCase(theme)
                .onSuccess {
                    _countUiState.value = UiState.Success(it)
                }.onFailure {
                    _countUiState.value = UiState.Error(it.message)
                }
        }
    }
}
