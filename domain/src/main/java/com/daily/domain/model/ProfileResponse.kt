package com.daily.domain.model

import java.util.UUID

data class ProfileResponse(
    val idx: UUID,
    val name: String,
    val email: String,
    val profileUrl: String?
)
