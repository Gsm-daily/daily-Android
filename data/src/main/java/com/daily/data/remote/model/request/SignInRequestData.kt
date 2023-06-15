package com.daily.data.remote.model.request

import com.daily.domain.model.request.SignInRequest

data class SignInRequestData(
    val email: String,
    val password: String
)

fun SignInRequest.asSignInRequestData() = SignInRequestData(
    email = email,
    password = password,
)

