package com.daily.domain.repository

interface EmailRepository {
    suspend fun sendVerificationCode(email: String)

    suspend fun verifyAuthKey(authKey: Int)
}