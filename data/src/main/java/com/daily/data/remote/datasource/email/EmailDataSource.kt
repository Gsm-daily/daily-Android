package com.daily.data.remote.datasource.email

interface EmailDataSource {
    suspend fun sendVerificationCode(email: String)
}