package com.daily.domain.model.response

import java.util.UUID

data class ProfileResponse(
    val idx: UUID,
    val name: String,
    val email: String,
    val profileUrl: String?
)
