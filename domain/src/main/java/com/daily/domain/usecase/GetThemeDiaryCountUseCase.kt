package com.daily.domain.usecase

import com.daily.domain.repository.AccountRepository
import javax.inject.Inject

class GetThemeDiaryCountUseCase @Inject constructor(
    private val repository: AccountRepository
) {
    suspend operator fun invoke(theme: String) = kotlin.runCatching { repository.getThemeDiaryCount(theme) }
}