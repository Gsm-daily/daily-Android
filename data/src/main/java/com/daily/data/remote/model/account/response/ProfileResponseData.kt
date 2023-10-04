package com.daily.data.remote.model.account.response

import com.daily.domain.model.response.ProfileResponse

data class ProfileResponseData(
    val name: String,
    val email: String,
    val profileUrl: String?
)

fun ProfileResponseData.asProfileResponse() = ProfileResponse(
    name = name,
    email = email,
    profileUrl = profileUrl
)
