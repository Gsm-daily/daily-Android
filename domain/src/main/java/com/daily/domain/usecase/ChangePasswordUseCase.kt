package com.daily.domain.usecase

import com.daily.domain.model.ChangePasswordRequest
import com.daily.domain.repository.AccountRepository
import javax.inject.Inject

class ChangePasswordUseCase @Inject constructor(
    private val repository: AccountRepository
) {
    suspend operator fun invoke(changePasswordRequest: ChangePasswordRequest) = kotlin.runCatching { repository.changePassword(changePasswordRequest) }
}