package com.daily.data.remote.datasource.auth

import com.daily.data.remote.model.request.ChangePasswordRequestData
import com.daily.data.remote.model.request.SignInRequestData
import com.daily.data.remote.model.response.SignInResponseData
import com.daily.data.remote.model.request.SignUpRequestData

interface AuthDataSource {
    suspend fun signIn(signInRequestData: SignInRequestData): SignInResponseData

    suspend fun signUp(signUpRequestData: SignUpRequestData)

    suspend fun checkDuplicateEmail(email: String)

    suspend fun checkDuplicateName(name: String)

    suspend fun changePassword(changePasswordRequestData: ChangePasswordRequestData)
}