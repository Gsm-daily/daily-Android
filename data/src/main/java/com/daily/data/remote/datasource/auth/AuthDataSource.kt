package com.daily.data.remote.datasource.auth

import com.daily.data.remote.model.SignInRequestData
import com.daily.data.remote.model.SignUpRequestData

interface AuthDataSource {
    suspend fun signIn(signInRequestData: SignInRequestData)

    suspend fun signUp(signUpRequestData: SignUpRequestData)

    suspend fun checkDuplicateEmail(email: String)

    suspend fun checkDuplicateName(name: String)
}