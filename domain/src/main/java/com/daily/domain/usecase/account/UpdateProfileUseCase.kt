package com.daily.domain.usecase.account

import com.daily.domain.model.account.request.ProfileRequest
import com.daily.domain.repository.AccountRepository
import javax.inject.Inject

class UpdateProfileUseCase @Inject constructor(
    private val repository: AccountRepository
) {
    suspend operator fun invoke(body: ProfileRequest) = kotlin.runCatching { repository.updateProfile(body) }
}
