package com.daily.data.remote.datasource.account

import com.daily.data.remote.model.ChangePasswordRequestData

interface AccountDataSource {
    suspend fun choiceTheme(theme: String)

    suspend fun changePassword(changePasswordRequestData: ChangePasswordRequestData)
}