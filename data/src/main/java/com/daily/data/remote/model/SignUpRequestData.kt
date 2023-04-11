package com.daily.data.remote.model

import com.daily.domain.model.SignUpRequest

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

