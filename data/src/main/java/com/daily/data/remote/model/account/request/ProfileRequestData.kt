package com.daily.data.remote.model.account.request

import com.daily.domain.model.request.ProfileRequest

data class ProfileRequestData(
    val name: String,
    val email: String,
    val profileUrl: String?
)

fun ProfileRequest.asProfileRequestData() = ProfileRequestData(
    name = name,
    email = email,
    profileUrl = profileUrl
)
