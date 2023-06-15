package com.daily.domain.usecase

import com.daily.domain.model.request.SignUpRequest
import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signUpRequest: SignUpRequest) =
        kotlin.runCatching { authRepository.signUp(signUpRequest) }
}