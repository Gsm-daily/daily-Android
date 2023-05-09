package com.daily.domain.model

data class ChangePasswordRequest(
    val email: String,
    val password: String,
    val newPassword: String
)
