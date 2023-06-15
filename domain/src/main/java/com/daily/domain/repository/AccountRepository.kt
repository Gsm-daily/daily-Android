package com.daily.domain.repository

import com.daily.domain.model.ProfileRequest
import com.daily.domain.model.ProfileResponse
import com.daily.domain.model.ThemeCountResponse
import com.daily.domain.model.ThemeResponse

interface AccountRepository {
    suspend fun choiceTheme(theme: String)

    suspend fun getTheme(): ThemeResponse

    suspend fun getThemeDiaryCount(theme: String): ThemeCountResponse

    suspend fun getProfile(): ProfileResponse

    suspend fun updateProfile(body: ProfileRequest)
}