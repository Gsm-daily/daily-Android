package com.daily.domain.repository

interface AccountRepository {
    suspend fun choiceTheme(theme: String)
}