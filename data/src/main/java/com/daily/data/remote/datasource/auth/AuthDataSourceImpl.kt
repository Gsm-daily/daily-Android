package com.daily.data.remote.datasource.auth

import com.daily.data.remote.model.SignUpRequestData
import com.daily.data.remote.network.api.AuthApi
import com.daily.data.remote.util.safeApiCall
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthDataSource {
    override suspend fun signUp(signUpRequestData: SignUpRequestData) {
        safeApiCall { authApi.signUp(signUpRequestData) }
    }

    override suspend fun checkDuplicateEmail(email: String) {
        safeApiCall { authApi.checkDuplicateEmail(email) }
    }
}