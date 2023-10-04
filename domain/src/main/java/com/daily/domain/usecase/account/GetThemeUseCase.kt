package com.daily.domain.usecase.account

import com.daily.domain.repository.AccountRepository
import javax.inject.Inject

class GetThemeUseCase @Inject constructor(
    private val repository: AccountRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { repository.getTheme() }
}
