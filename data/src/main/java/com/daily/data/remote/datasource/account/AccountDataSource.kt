package com.daily.data.remote.datasource.account

import com.daily.data.remote.model.request.ProfileRequestData
import com.daily.data.remote.model.response.ProfileResponseData
import com.daily.data.remote.model.response.ThemeCountResponseData
import com.daily.data.remote.model.response.ThemeResponseData

interface AccountDataSource {
    suspend fun choiceTheme(theme: String)

    suspend fun getTheme(): ThemeResponseData

    suspend fun getThemeDiaryCount(theme: String): ThemeCountResponseData

    suspend fun getProfile(): ProfileResponseData

    suspend fun updateProfile(body: ProfileRequestData)
}