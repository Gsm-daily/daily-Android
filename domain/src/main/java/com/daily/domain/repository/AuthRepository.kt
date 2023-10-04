package com.daily.domain.repository

import com.daily.domain.model.auth.request.ChangePasswordRequest
import com.daily.domain.model.auth.request.SignInRequest
import com.daily.domain.model.auth.response.SignInResponse
import com.daily.domain.model.auth.request.SignUpRequest

interface AuthRepository {
    suspend fun signIn(signInRequest: SignInRequest): SignInResponse

    suspend fun signUp(signUpRequest: SignUpRequest)

    suspend fun checkDuplicateEmail(email: String)

    suspend fun checkDuplicateName(name: String)

    suspend fun saveToken(accessToken: String, refreshToken: String, accessTokenExpiredAt: String, refreshTokenExpiredAt: String)

    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest)
}
