package com.daily.domain.repository

import com.daily.domain.model.account.request.ProfileRequest
import com.daily.domain.model.account.response.ProfileResponse
import com.daily.domain.model.account.response.ThemeCountResponse
import com.daily.domain.model.account.response.ThemeResponse

interface AccountRepository {
    suspend fun choiceTheme(theme: String)

    suspend fun getTheme(): ThemeResponse

    suspend fun getThemeDiaryCount(theme: String): ThemeCountResponse

    suspend fun getProfile(): ProfileResponse

    suspend fun updateProfile(body: ProfileRequest)
}
