package com.daily.data.remote.model

import java.util.UUID

data class ProfileRequestData(
    val idx: UUID,
    val name: String,
    val email: String,
    val profileUrl: String?
)
