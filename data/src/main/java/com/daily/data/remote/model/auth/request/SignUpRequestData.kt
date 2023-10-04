package com.daily.data.remote.model.auth.request

import com.daily.domain.model.auth.request.SignUpRequest

data class SignUpRequestData(
    val email: String,
    val password: String,
    val name: String
)

fun SignUpRequest.asSignUpRequestData() = SignUpRequestData(
    email = email,
    password = password,
    name = name
)

