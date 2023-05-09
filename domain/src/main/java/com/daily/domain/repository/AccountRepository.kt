package com.daily.domain.repository

import com.daily.domain.model.ChangePasswordRequest

interface AccountRepository {
    suspend fun choiceTheme(theme: String)

    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest)
}