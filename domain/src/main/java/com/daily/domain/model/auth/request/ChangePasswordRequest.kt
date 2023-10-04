package com.daily.domain.model.auth.request

data class ChangePasswordRequest(
    val email: String,
    val newPassword: String
)
