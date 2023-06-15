package com.daily.data.repository

import com.daily.data.remote.datasource.account.AccountDataSource
import com.daily.data.remote.model.request.asProfileRequestData
import com.daily.data.remote.model.response.asProfileResponse
import com.daily.data.remote.model.response.asThemeCountResponse
import com.daily.data.remote.model.response.asThemeResponse
import com.daily.domain.model.request.ProfileRequest
import com.daily.domain.model.response.ProfileResponse
import com.daily.domain.model.response.ThemeCountResponse
import com.daily.domain.model.response.ThemeResponse
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

    override suspend fun getProfile(): ProfileResponse {
        return accountDataSource.getProfile().asProfileResponse()
    }

    override suspend fun updateProfile(body: ProfileRequest) {
        return accountDataSource.updateProfile(body.asProfileRequestData())
    }
}