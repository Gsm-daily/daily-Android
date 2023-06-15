package com.daily.domain.model.request

import java.util.UUID

data class ProfileRequest(
    val idx: UUID,
    val name: String,
    val email: String,
    val profileUrl: String?
)

