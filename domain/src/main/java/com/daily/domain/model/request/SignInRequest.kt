package com.daily.domain.model.request

data class SignInRequest(
    val email: String,
    val password: String
)