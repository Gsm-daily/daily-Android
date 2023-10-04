package com.daily.domain.model.auth.response

data class SignInResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiredAt: String,
    val refreshTokenExpiredAt: String
)
