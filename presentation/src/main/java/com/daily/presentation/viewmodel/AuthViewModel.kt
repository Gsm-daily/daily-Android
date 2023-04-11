package com.daily.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.SignUpRequest
import com.daily.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    fun signUp(signUpRequest: SignUpRequest) {
        viewModelScope.launch {
            signUpUseCase(signUpRequest)
        }
    }
}