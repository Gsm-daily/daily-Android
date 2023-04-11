package com.daily.data.remote.network.api

import com.daily.data.remote.model.SignUpRequestData
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/signup")
    suspend fun signUp(
        @Body body: SignUpRequestData
    )
}