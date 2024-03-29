package com.daily.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.auth.request.SignInRequest
import com.daily.domain.model.auth.request.SignUpRequest
import com.daily.domain.usecase.auth.CheckDuplicateEmailUseCase
import com.daily.domain.usecase.auth.CheckDuplicateNameUseCase
import com.daily.domain.usecase.auth.SaveTokenUseCase
import com.daily.domain.usecase.auth.SignInUseCase
import com.daily.domain.usecase.auth.SignUpUseCase
import com.daily.presentation.viewmodel.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase,
    private val checkDuplicateEmailUseCase: CheckDuplicateEmailUseCase,
    private val checkDuplicateNameUseCase: CheckDuplicateNameUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {
    private val _signInUiState = MutableStateFlow<UiState<Nothing>>(UiState.Loading)
    val signInUiState = _signInUiState.asStateFlow()

    private val _signUpUiState = MutableStateFlow<UiState<Nothing>>(UiState.Loading)
    val signUpUiState = _signUpUiState.asStateFlow()

    private val _duplicateEmailUiState = MutableStateFlow<UiState<Nothing>>(UiState.Loading)
    val duplicateEmailUiState = _duplicateEmailUiState.asStateFlow()

    private val _duplicateNameUiState = MutableStateFlow<UiState<Nothing>>(UiState.Loading)
    val duplicateNameUiState = _duplicateNameUiState.asStateFlow()

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            signInUseCase(
                SignInRequest(email = email, password = password)
            )
                .onSuccess {
                    saveTokenUseCase(
                        accessToken = it.accessToken,
                        refreshToken = it.refreshToken,
                        accessTokenExpiredAt = it.accessTokenExpiredAt,
                        refreshTokenExpiredAt = it.refreshTokenExpiredAt
                    )
                    _signInUiState.value = UiState.Success()
                }.onFailure {
                    _signInUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun signUp(email: String, password: String, nickname: String) {
        viewModelScope.launch {
            signUpUseCase(
                SignUpRequest(email = email, password = password, name = nickname)
            )
                .onSuccess {
                    _signUpUiState.value = UiState.Success()
                }.onFailure {
                    _signInUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun checkDuplicateEmail(email: String) {
        viewModelScope.launch {
            checkDuplicateEmailUseCase(email)
                .onSuccess {
                    _duplicateEmailUiState.value = UiState.Success()
                }.onFailure {
                    _duplicateEmailUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun checkDuplicateName(name: String) {
        viewModelScope.launch {
            checkDuplicateNameUseCase(name)
                .onSuccess {
                    _duplicateNameUiState.value = UiState.Success()
                }.onFailure {
                    _duplicateNameUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun resetEmailUiState() {
        _duplicateEmailUiState.value = UiState.Loading
    }
}
