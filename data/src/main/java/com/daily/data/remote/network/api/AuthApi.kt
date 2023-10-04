package com.daily.data.remote.network.api

import com.daily.data.remote.model.auth.request.ChangePasswordRequestData
import com.daily.data.remote.model.auth.request.SignInRequestData
import com.daily.data.remote.model.auth.response.SignInResponseData
import com.daily.data.remote.model.auth.request.SignUpRequestData
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {
    @POST("/api/v1/auth/signin")
    suspend fun signIn(
        @Body body: SignInRequestData
    ): SignInResponseData

    @POST("/api/v1/auth/signup")
    suspend fun signUp(
        @Body body: SignUpRequestData
    )

    @POST("/api/v1/auth/email")
    suspend fun checkDuplicateEmail(
        @Query("email") email: String
    )

    @POST("/api/v1/auth/name")
    suspend fun checkDuplicateName(
        @Query("name") name: String
    )

    @PATCH("/api/v1/auth/password")
    suspend fun changePassword(
        @Body body: ChangePasswordRequestData
    )
}
