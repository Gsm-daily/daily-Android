package com.daily.data.remote.datasource.account

import com.daily.data.remote.model.ProfileRequestData
import com.daily.data.remote.model.ProfileResponseData
import com.daily.data.remote.model.SelectThemeRequestData
import com.daily.data.remote.model.ThemeResponseData
import com.daily.data.remote.network.api.AccountApi
import com.daily.data.remote.util.safeApiCall
import javax.inject.Inject

class AccountDataSourceImpl @Inject constructor(
    private val accountApi: AccountApi
) : AccountDataSource {
    override suspend fun choiceTheme(theme: String) { safeApiCall { accountApi.choiceTheme(SelectThemeRequestData(theme)) } }

    override suspend fun getTheme(): ThemeResponseData = safeApiCall { accountApi.getTheme() }

    override suspend fun getThemeDiaryCount(theme: String) = safeApiCall { accountApi.getThemeDiaryCount(theme) }

    override suspend fun getProfile(): ProfileResponseData = safeApiCall { accountApi.getProfile() }

    override suspend fun updateProfile(body: ProfileRequestData) = safeApiCall { accountApi.updateProfile(body) }
}