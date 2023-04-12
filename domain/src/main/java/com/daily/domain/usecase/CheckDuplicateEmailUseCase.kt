package com.daily.domain.usecase

import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class CheckDuplicateEmailUseCase @Inject constructor(
  private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String) = kotlin.runCatching { authRepository.checkDuplicateEmail(email) }
}