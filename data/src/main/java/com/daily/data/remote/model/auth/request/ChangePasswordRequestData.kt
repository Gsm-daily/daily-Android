package com.daily.data.remote.model.auth.request

import com.daily.domain.model.request.ChangePasswordRequest

data class ChangePasswordRequestData(
    val email: String,
    val newPassword: String
)

fun ChangePasswordRequest.asChangePasswordRequest() = ChangePasswordRequestData(
    email = email,
    newPassword = newPassword
)
