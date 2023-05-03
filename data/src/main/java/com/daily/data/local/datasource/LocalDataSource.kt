package com.daily.data.local.datasource

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveToken(
        accessToken: String,
        refreshToken: String,
        accessTokenExpiredAt: String
    )

    suspend fun getAccessToken(): Flow<String>

    suspend fun getRefreshToken(): Flow<String>

    suspend fun getAccessTokenExpiredAt(): Flow<String>
}