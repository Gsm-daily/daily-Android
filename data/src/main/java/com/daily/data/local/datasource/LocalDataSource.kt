package com.daily.data.local.datasource

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveToken(
        accessToken: String,
        refreshToken: String,
        accessTokenExpiredAt: String,
        refreshTokenExpiredAt: String
    )

    fun getAccessToken(): Flow<String>

    fun getRefreshToken(): Flow<String>

    fun getAccessTokenExpiredAt(): Flow<String>

    fun getRefreshTokenExpiredAt(): Flow<String>
}