package com.daily.domain.repository

interface EmailRepository {
    suspend fun sendEmailForSignUp(email: String)

    suspend fun verifyAuthKey(authKey: Int)

    suspend fun sendEmailForPasswordChange(email: String)
}