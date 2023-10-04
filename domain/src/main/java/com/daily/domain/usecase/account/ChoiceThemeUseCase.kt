package com.daily.domain.usecase.account

import com.daily.domain.repository.AccountRepository
import javax.inject.Inject

class ChoiceThemeUseCase @Inject constructor(
    private val repository: AccountRepository
) {
    suspend operator fun invoke(theme: String) = kotlin.runCatching { repository.choiceTheme(theme) }
}
