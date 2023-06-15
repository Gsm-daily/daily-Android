package com.daily.data.remote.model

import com.daily.domain.model.ProfileResponse
import java.util.UUID

data class ProfileResponseData(
    val idx: UUID,
    val name: String,
    val email: String,
    val profileUrl: String?
)

fun ProfileResponseData.asProfileResponse() = ProfileResponse(
    idx = idx,
    name = name,
    email = email,
    profileUrl = profileUrl
)
