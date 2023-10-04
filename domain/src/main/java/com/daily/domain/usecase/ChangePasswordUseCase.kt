package com.daily.domain.usecase

import com.daily.domain.model.auth.request.ChangePasswordRequest
import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class ChangePasswordUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(changePasswordRequest: ChangePasswordRequest) = kotlin.runCatching { repository.changePassword(changePasswordRequest) }
}
