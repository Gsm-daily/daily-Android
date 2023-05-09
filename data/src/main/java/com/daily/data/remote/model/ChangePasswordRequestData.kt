package com.daily.data.remote.model

import com.daily.domain.model.ChangePasswordRequest

data class ChangePasswordRequestData(
    val email: String,
    val password: String,
    val newPassword: String
)

fun ChangePasswordRequest.asChangePasswordRequest() = ChangePasswordRequestData(
    email = email,
    password = password,
    newPassword = newPassword
)
