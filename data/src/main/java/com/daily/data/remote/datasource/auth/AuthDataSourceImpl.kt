package com.daily.data.remote.datasource.auth

import com.daily.data.remote.model.auth.request.ChangePasswordRequestData
import com.daily.data.remote.model.auth.request.SignInRequestData
import com.daily.data.remote.model.auth.response.SignInResponseData
import com.daily.data.remote.model.auth.request.SignUpRequestData
import com.daily.data.remote.network.api.AuthApi
import com.daily.data.remote.util.safeApiCall
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthDataSource {
    override suspend fun signIn(signInRequestData: SignInRequestData): SignInResponseData {
        return safeApiCall { authApi.signIn(signInRequestData) }
    }

    override suspend fun signUp(signUpRequestData: SignUpRequestData) {
        safeApiCall { authApi.signUp(signUpRequestData) }
    }

    override suspend fun checkDuplicateEmail(email: String) {
        safeApiCall { authApi.checkDuplicateEmail(email) }
    }

    override suspend fun checkDuplicateName(name: String) {
        safeApiCall { authApi.checkDuplicateName(name) }
    }

    override suspend fun changePassword(changePasswordRequestData: ChangePasswordRequestData) {
        safeApiCall { authApi.changePassword(changePasswordRequestData) }
    }
}
