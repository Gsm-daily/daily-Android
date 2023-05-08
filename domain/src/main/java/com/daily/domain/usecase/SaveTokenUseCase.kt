package com.daily.domain.usecase

import com.daily.domain.repository.AuthRepository
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(accessToken: String, refreshToken: String, accessTokenExpiredAt: String, refreshTokenExpiredAt: String) =
        repository.saveToken(accessToken, refreshToken, accessTokenExpiredAt, refreshTokenExpiredAt)
}