package com.daily.di

import com.daily.data.repository.AccountRepositoryImpl
import com.daily.data.repository.AuthRepositoryImpl
import com.daily.data.repository.DiaryRepositoryImpl
import com.daily.data.repository.EmailRepositoryImpl
import com.daily.domain.repository.AccountRepository
import com.daily.domain.repository.AuthRepository
import com.daily.domain.repository.DiaryRepository
import com.daily.domain.repository.EmailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    fun bindsEmailRepository(
        emailRepositoryImpl: EmailRepositoryImpl
    ): EmailRepository

    @Binds
    fun bindsAccountRepository(
        accountRepositoryImpl: AccountRepositoryImpl
    ): AccountRepository

    @Binds
    fun bindsDiaryRepository(
        diaryRepositoryImpl: DiaryRepositoryImpl
    ): DiaryRepository
}