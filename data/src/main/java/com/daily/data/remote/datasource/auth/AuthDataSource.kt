package com.daily.data.remote.datasource.auth

import com.daily.data.remote.model.SignUpRequestData

interface AuthDataSource {
    suspend fun signUp(signUpRequestData: SignUpRequestData)

    suspend fun checkDuplicateEmail(email: String)
}