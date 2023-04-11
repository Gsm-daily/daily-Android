package com.daily.data.remote.datasource.auth

import com.daily.data.remote.model.SignUpRequestData
import com.daily.data.remote.network.api.AuthApi
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthDataSource {
    override suspend fun signUp(signUpRequestData: SignUpRequestData) {
        authApi.signUp(signUpRequestData)
    }
}