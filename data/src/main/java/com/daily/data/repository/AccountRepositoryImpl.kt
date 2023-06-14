package com.daily.data.repository

import com.daily.data.remote.datasource.account.AccountDataSource
import com.daily.data.remote.model.asThemeCountResponse
import com.daily.data.remote.model.asThemeResponse
import com.daily.domain.model.ThemeCountResponse
import com.daily.domain.model.ThemeResponse
import com.daily.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountDataSource: AccountDataSource
): AccountRepository {
    override suspend fun choiceTheme(theme: String) {
        accountDataSource.choiceTheme(theme)
    }

    override suspend fun getTheme(): ThemeResponse {
        return accountDataSource.getTheme().asThemeResponse()
    }

    override suspend fun getThemeDiaryCount(theme: String): ThemeCountResponse {
        return accountDataSource.getThemeDiaryCount(theme).asThemeCountResponse()
    }
}