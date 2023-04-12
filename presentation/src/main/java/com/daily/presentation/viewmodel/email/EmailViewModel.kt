package com.daily.presentation.viewmodel.email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.usecase.SendVerificationCodeUseCase
import com.daily.presentation.viewmodel.util.ExceptionType
import com.daily.presentation.viewmodel.util.exceptionHandling
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class EmailViewModel @Inject constructor(
    private val sendVerificationCodeUseCase: SendVerificationCodeUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<EmailUiState>(EmailUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun sendVerificationCode(email: String) {
        viewModelScope.launch {
            sendVerificationCodeUseCase(email)
                .onSuccess { _uiState.value = EmailUiState.Success }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = {
                            _uiState.value = EmailUiState.Error(ExceptionType.BadRequestException)
                        },
                        notFoundAction = {
                            _uiState.value = EmailUiState.Error(ExceptionType.NotFoundException)
                        }
                    )
                }
        }
    }
}