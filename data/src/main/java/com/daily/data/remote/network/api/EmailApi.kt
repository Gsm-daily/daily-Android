package com.daily.data.remote.network.api

import retrofit2.http.Body
import retrofit2.http.POST

interface EmailApi {
    @POST("/api/v1/email/signup")
    suspend fun sendEmailForSignUp(
        @Body email: String
    )

    @POST("/api/v1/email/verify-authkey")
    suspend fun verifyAuthKey(
        @Body authKey: Int
    )
}