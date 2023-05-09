package com.daily.data.remote.model

import com.daily.domain.model.ChangePasswordRequest

data class ChangePasswordRequestData(
    val email: String,
    val newPassword: String
)

fun ChangePasswordRequest.asChangePasswordRequest() = ChangePasswordRequestData(
    email = email,
    newPassword = newPassword
)
