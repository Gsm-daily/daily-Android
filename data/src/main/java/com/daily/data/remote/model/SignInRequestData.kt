package com.daily.data.remote.model

import com.daily.domain.model.SignInRequest

data class SignInRequestData(
    val email: String,
    val password: String
)

fun SignInRequest.asSignInRequestData() = SignInRequestData(
    email = email,
    password = password,
)

