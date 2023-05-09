package com.daily.domain.model

data class ChangePasswordRequest(
    val email: String,
    val newPassword: String
)
