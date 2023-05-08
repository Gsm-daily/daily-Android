package com.daily.data.local.datasource

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.daily.data.local.util.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
): LocalDataSource {
    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("access_token")
        private val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
        private val ACCESS_TOKEN_EXPIRED_AT = stringPreferencesKey("access_token_expired_at")
        private val REFRESH_TOKEN_EXPIRED_AT = stringPreferencesKey("refresh_token_expired_at")
    }

    override suspend fun saveToken(accessToken: String, refreshToken: String, accessTokenExpiredAt: String, refreshTokenExpiredAt: String) {
        context.dataStore.edit {
            it[ACCESS_TOKEN] = accessToken
            it[REFRESH_TOKEN] = refreshToken
            it[ACCESS_TOKEN_EXPIRED_AT] = accessTokenExpiredAt
            it[REFRESH_TOKEN_EXPIRED_AT] = refreshTokenExpiredAt
        }
    }

    override fun getAccessToken(): Flow<String> = context.dataStore.data.map { it[ACCESS_TOKEN] ?: "" }

    override fun getRefreshToken(): Flow<String> = context.dataStore.data.map { it[REFRESH_TOKEN] ?: "" }

    override fun getAccessTokenExpiredAt(): Flow<String> = context.dataStore.data.map { it[ACCESS_TOKEN_EXPIRED_AT] ?: "" }
    override fun getRefreshTokenExpiredAt(): Flow<String> = context.dataStore.data.map { it[REFRESH_TOKEN_EXPIRED_AT] ?: "" }
}