package com.daily.data.remote.model.auth.response

import com.daily.domain.model.response.SignInResponse

data class SignInResponseData(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiredAt: String,
    val refreshTokenExpiredAt: String
)

fun SignInResponseData.asSignInResponse() = SignInResponse(
    accessToken = accessToken,
    refreshToken = refreshToken,
    accessTokenExpiredAt = accessTokenExpiredAt,
    refreshTokenExpiredAt = refreshTokenExpiredAt
)
