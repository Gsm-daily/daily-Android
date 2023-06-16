package com.daily.domain.model.request

data class ProfileRequest(
    val name: String,
    val email: String,
    val profileUrl: String?
)

