package com.daily.data.remote.model

import com.daily.domain.model.ProfileRequest
import java.util.UUID

data class ProfileRequestData(
    val idx: UUID,
    val name: String,
    val email: String,
    val profileUrl: String?
)

fun ProfileRequest.asProfileRequestData() = ProfileRequestData(
    idx = idx,
    name = name,
    email = email,
    profileUrl = profileUrl
)