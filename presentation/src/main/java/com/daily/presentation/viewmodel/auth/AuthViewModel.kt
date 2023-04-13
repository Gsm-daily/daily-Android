package com.daily.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.SignUpRequest
import com.daily.domain.usecase.CheckDuplicateEmailUseCase
import com.daily.domain.usecase.CheckDuplicateNameUseCase
import com.daily.domain.usecase.SignUpUseCase
import com.daily.presentation.viewmodel.util.UiState
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
    private val _signUpUiState = MutableStateFlow<UiState>(UiState.Loading)
    val signUpUiState = _signUpUiState.asStateFlow()

    private val _duplicateEmailUiState = MutableStateFlow<UiState>(UiState.Loading)
    val duplicateEmailUiState = _duplicateEmailUiState.asStateFlow()

    private val _duplicateNameUiState = MutableStateFlow<UiState>(UiState.Loading)
    val duplicateNameUiState = _duplicateNameUiState.asStateFlow()

    fun signUp(email: String, password: String, nickname: String) {
        val signUpRequest = SignUpRequest(
            email = email,
            password = password,
            name = nickname
        )
        viewModelScope.launch {
            signUpUseCase(signUpRequest)
                .onSuccess { _signUpUiState.value = UiState.Success }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = { _signUpUiState.value = UiState.BadRequest },
                        conflictAction = { _signUpUiState.value = UiState.Conflict }
                    )
                }
        }
    }

    fun checkDuplicateEmail(email: String, ) {
        viewModelScope.launch {
            checkDuplicateEmailUseCase(email)
                .onSuccess { _duplicateEmailUiState.value = UiState.Success }
                .onFailure {
                    it.exceptionHandling(conflictAction = { _duplicateEmailUiState.value = UiState.Conflict })
                }
        }
    }

    fun checkDuplicateName(name: String) {
        viewModelScope.launch {
            checkDuplicateNameUseCase(name)
                .onSuccess { _duplicateNameUiState.value = UiState.Success }
                .onFailure {
                    it.exceptionHandling(conflictAction = { _duplicateNameUiState.value = UiState.Conflict })
                }
        }
    }
}