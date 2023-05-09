package com.daily.data.remote.model

data class ChangePasswordRequestData(
    val email: String,
    val password: String,
    val newPassword: String
)
