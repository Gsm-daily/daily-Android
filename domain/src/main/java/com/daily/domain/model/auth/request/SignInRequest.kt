package com.daily.domain.model.auth.request

data class SignInRequest(
    val email: String,
    val password: String
)
