package com.daily.data.remote.network.api

import com.daily.data.remote.model.EmailRequestData
import com.daily.data.remote.model.VerifyAuthKeyRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface EmailApi {
    @POST("/api/v1/email/signup")
    suspend fun sendEmailForSignUp(
        @Body email: EmailRequestData
    )

    @POST("/api/v1/email/verify-authkey")
    suspend fun verifyAuthKey(
        @Body authKey: VerifyAuthKeyRequest
    )

    @POST("/api/v1/email/password")
    suspend fun sendEmailForPasswordChange(
        @Body email: EmailRequestData
    )
}