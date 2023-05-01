package com.daily.data.remote.model

import com.daily.domain.model.SignInResponse

data class SignInResponseData(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiredAt: String
)

fun SignInResponseData.asSignInResponse() = SignInResponse(
    accessToken = accessToken,
    refreshToken = refreshToken,
    accessTokenExpiredAt = accessTokenExpiredAt
)