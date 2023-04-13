package com.daily.presentation.viewmodel.email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.usecase.SendEmailForPasswordChangeUseCase
import com.daily.domain.usecase.SendEmailForSignUpUseCase
import com.daily.domain.usecase.VerifyAuthKeyUseCase
import com.daily.presentation.viewmodel.util.UiState
import com.daily.presentation.viewmodel.util.exceptionHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmailViewModel @Inject constructor(
    private val sendEmailForSignUpUseCase: SendEmailForSignUpUseCase,
    private val verificationCodeUseCase: VerifyAuthKeyUseCase,
    private val sendEmailForPasswordChangeUseCase: SendEmailForPasswordChangeUseCase
) : ViewModel() {
    private val _signUpEmailUiState = MutableStateFlow<UiState>(UiState.Loading)
    val signUpEmailUiState = _signUpEmailUiState.asStateFlow()

    private val _verifyUiState = MutableStateFlow<UiState>(UiState.Loading)
    val verifyUiState = _verifyUiState

    private val _passwordChangeEmailUiState = MutableStateFlow<UiState>(UiState.Loading)
    val passwordChangeUiState = _passwordChangeEmailUiState.asStateFlow()

    fun sendEmailForSignUp(email: String) {
        viewModelScope.launch {
            sendEmailForSignUpUseCase(email)
                .onSuccess { _signUpEmailUiState.value = UiState.Success }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = { _signUpEmailUiState.value = UiState.BadRequest },
                        notFoundAction = { _signUpEmailUiState.value = UiState.NotFound }
                    )
                }
        }
    }

    fun verifyAuthKey(authKey: Int) {
        viewModelScope.launch {
            verificationCodeUseCase(authKey)
                .onSuccess { _verifyUiState.value = UiState.Success }
                .onFailure {
                    it.exceptionHandling(badRequestAction = { _verifyUiState.value = UiState.BadRequest })
                }
        }
    }

    fun sendEmailForPasswordChange(email: String) {
        viewModelScope.launch {
            sendEmailForPasswordChangeUseCase(email)
                .onSuccess { _passwordChangeEmailUiState.value = UiState.Success }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = { _passwordChangeEmailUiState.value = UiState.BadRequest },
                        notFoundAction = { _passwordChangeEmailUiState.value = UiState.NotFound }
                    )
                }
        }
    }
}