package com.daily.data.remote.datasource.account

import com.daily.data.remote.model.ThemeResponseData

interface AccountDataSource {
    suspend fun choiceTheme(theme: String)

    suspend fun getTheme(): ThemeResponseData

    suspend fun getThemeDiaryCount(theme: String)
}