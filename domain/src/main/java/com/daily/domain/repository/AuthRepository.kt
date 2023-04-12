package com.daily.domain.repository

import com.daily.domain.model.SignUpRequest

interface AuthRepository {
    suspend fun signUp(signUpRequest: SignUpRequest)

    suspend fun checkDuplicateEmail(email: String)

    suspend fun checkDuplicateName(name: String)
}