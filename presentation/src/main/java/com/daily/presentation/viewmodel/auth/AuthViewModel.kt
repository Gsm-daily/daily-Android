package com.daily.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.SignUpRequest
import com.daily.domain.usecase.CheckDuplicateEmailUseCase
import com.daily.domain.usecase.CheckDuplicateNameUseCase
import com.daily.domain.usecase.SignUpUseCase
import com.daily.presentation.viewmodel.util.ExceptionType
import com.daily.presentation.viewmodel.util.exceptionHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val checkDuplicateEmailUseCase: CheckDuplicateEmailUseCase,
    private val checkDuplicateNameUseCase: CheckDuplicateNameUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun signUp(email: String, password: String, nickname: String) {
        val signUpRequest = SignUpRequest(
            email = email,
            password = password,
            name = nickname
        )
        viewModelScope.launch {
            signUpUseCase(signUpRequest)
                .onSuccess { _uiState.value = AuthUiState.Success }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = {
                            _uiState.value = AuthUiState.Error(exception = ExceptionType.BadRequestException)
                        },
                        conflictAction = {
                            _uiState.value = AuthUiState.Error(exception = ExceptionType.ConflictException)
                        }
                    )
                }
        }
    }

    fun checkDuplicateEmail(email: String) {
        viewModelScope.launch {
            checkDuplicateEmailUseCase(email)
                .onSuccess { _uiState.value = AuthUiState.Success }
                .onFailure {
                    it.exceptionHandling(conflictAction = {
                        _uiState.value = AuthUiState.Error(exception = ExceptionType.ConflictException)
                    })
                }
        }
    }

    fun checkDuplicateName(name: String) {
        viewModelScope.launch {
            checkDuplicateNameUseCase(name)
                .onSuccess { _uiState.value = AuthUiState.Success }
                .onFailure {
                    it.exceptionHandling(conflictAction = {
                        _uiState.value = AuthUiState.Error(exception = ExceptionType.ConflictException)
                    })
                }
        }
    }
}