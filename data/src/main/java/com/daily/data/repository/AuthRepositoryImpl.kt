package com.daily.data.repository

import com.daily.data.remote.datasource.auth.AuthDataSource
import com.daily.data.remote.model.asSignUpRequestData
import com.daily.domain.model.SignUpRequest
import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
): AuthRepository {
    override suspend fun signUp(signUpRequest: SignUpRequest) {
        authDataSource.signUp(signUpRequest.asSignUpRequestData())
    }

    override suspend fun checkDuplicateEmail(email: String) {
        authDataSource.checkDuplicateEmail(email)
    }

    override suspend fun checkDuplicateName(name: String) {
        authDataSource.checkDuplicateName(name)
    }
}