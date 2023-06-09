package com.daily.data.repository

import com.daily.data.local.datasource.LocalDataSource
import com.daily.data.remote.datasource.auth.AuthDataSource
import com.daily.data.remote.model.request.asChangePasswordRequest
import com.daily.data.remote.model.request.asSignInRequestData
import com.daily.data.remote.model.response.asSignInResponse
import com.daily.data.remote.model.request.asSignUpRequestData
import com.daily.domain.model.request.ChangePasswordRequest
import com.daily.domain.model.request.SignInRequest
import com.daily.domain.model.response.SignInResponse
import com.daily.domain.model.request.SignUpRequest
import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val localDataSource: LocalDataSource
): AuthRepository {
    override suspend fun signIn(signInRequest: SignInRequest): SignInResponse {
        return authDataSource.signIn(signInRequest.asSignInRequestData()).asSignInResponse()
    }

    override suspend fun signUp(signUpRequest: SignUpRequest) {
        authDataSource.signUp(signUpRequest.asSignUpRequestData())
    }

    override suspend fun checkDuplicateEmail(email: String) {
        authDataSource.checkDuplicateEmail(email)
    }

    override suspend fun checkDuplicateName(name: String) {
        authDataSource.checkDuplicateName(name)
    }

    override suspend fun saveToken(accessToken: String, refreshToken: String, accessTokenExpiredAt: String, refreshTokenExpiredAt: String) {
        localDataSource.saveToken(accessToken, refreshToken, accessTokenExpiredAt, refreshTokenExpiredAt)
    }


    override suspend fun changePassword(changePasswordRequest: ChangePasswordRequest) {
        authDataSource.changePassword(changePasswordRequest.asChangePasswordRequest())
    }
}