package com.daily.domain.model.request

data class ChangePasswordRequest(
    val email: String,
    val newPassword: String
)
