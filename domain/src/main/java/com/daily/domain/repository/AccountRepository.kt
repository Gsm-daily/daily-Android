package com.daily.domain.repository

import com.daily.domain.model.ThemeResponse

interface AccountRepository {
    suspend fun choiceTheme(theme: String)

    suspend fun getTheme(): ThemeResponse

    suspend fun getThemeDiaryCount(theme: String)
}