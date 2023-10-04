package com.daily.domain.usecase.auth

import com.daily.domain.model.auth.request.SignUpRequest
import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signUpRequest: SignUpRequest) =
        kotlin.runCatching { authRepository.signUp(signUpRequest) }
}