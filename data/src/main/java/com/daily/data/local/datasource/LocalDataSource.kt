package com.daily.data.local.datasource

interface LocalDataSource {
    suspend fun saveToken(
        accessToken: String,
        refreshToken: String,
        accessTokenExpiredAt: String
    )
}