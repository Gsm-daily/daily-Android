package com.daily.data.remote.datasource.account

interface AccountDataSource {
    suspend fun choiceTheme(theme: String)
}