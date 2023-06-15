package com.daily.data.remote.datasource.account

import com.daily.data.remote.model.ProfileRequestData
import com.daily.data.remote.model.ProfileResponseData
import com.daily.data.remote.model.ThemeCountResponseData
import com.daily.data.remote.model.ThemeResponseData

interface AccountDataSource {
    suspend fun choiceTheme(theme: String)

    suspend fun getTheme(): ThemeResponseData

    suspend fun getThemeDiaryCount(theme: String): ThemeCountResponseData

    suspend fun getProfile(): ProfileResponseData

    suspend fun updateProfile(body: ProfileRequestData)
}