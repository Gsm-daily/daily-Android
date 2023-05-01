package com.daily.domain.model

data class SignInResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiredAt: String
)