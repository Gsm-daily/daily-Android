package com.daily.domain.model.request

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String
)