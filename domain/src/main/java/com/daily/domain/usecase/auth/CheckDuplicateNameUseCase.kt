package com.daily.domain.usecase.auth

import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class CheckDuplicateNameUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(name: String) = kotlin.runCatching { authRepository.checkDuplicateName(name) }
}
