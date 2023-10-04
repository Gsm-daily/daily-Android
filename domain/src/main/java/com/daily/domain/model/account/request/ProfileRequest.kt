package com.daily.domain.model.account.request

data class ProfileRequest(
    val name: String,
    val email: String,
    val profileUrl: String?
)

