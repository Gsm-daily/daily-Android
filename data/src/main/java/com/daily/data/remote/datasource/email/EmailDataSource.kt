package com.daily.data.remote.datasource.email

interface EmailDataSource {
    suspend fun sendEmailForSignUp(email: String)

    suspend fun verifyAuthKey(authKey: Int)
}