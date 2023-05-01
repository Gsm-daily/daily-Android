package com.daily.domain.repository

import com.daily.domain.model.SignInRequest
import com.daily.domain.model.SignInResponse
import com.daily.domain.model.SignUpRequest

interface AuthRepository {
    suspend fun signIn(signInRequest: SignInRequest): SignInResponse

    suspend fun signUp(signUpRequest: SignUpRequest)

    suspend fun checkDuplicateEmail(email: String)

    suspend fun checkDuplicateName(name: String)

    suspend fun saveToken(accessToken: String, refreshToken: String, accessTokenExpiredAt: String)
}