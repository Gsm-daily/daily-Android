package com.daily.data.remote.datasource.account

import com.daily.data.remote.model.account.request.ProfileRequestData
import com.daily.data.remote.model.account.response.ProfileResponseData
import com.daily.data.remote.model.account.response.ThemeCountResponseData
import com.daily.data.remote.model.account.response.ThemeResponseData

interface AccountDataSource {
    suspend fun choiceTheme(theme: String)

    suspend fun getTheme(): ThemeResponseData

    suspend fun getThemeDiaryCount(theme: String): ThemeCountResponseData

    suspend fun getProfile(): ProfileResponseData

    suspend fun updateProfile(body: ProfileRequestData)
}
