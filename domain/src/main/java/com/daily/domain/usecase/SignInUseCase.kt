package com.daily.domain.usecase

import com.daily.domain.model.request.SignInRequest
import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(signInRequest: SignInRequest) = kotlin.runCatching { repository.signIn(signInRequest) }
}