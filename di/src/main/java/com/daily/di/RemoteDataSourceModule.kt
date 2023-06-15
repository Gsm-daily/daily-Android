package com.daily.di

import com.daily.data.remote.datasource.account.AccountDataSource
import com.daily.data.remote.datasource.account.AccountDataSourceImpl
import com.daily.data.remote.datasource.auth.AuthDataSource
import com.daily.data.remote.datasource.auth.AuthDataSourceImpl
import com.daily.data.remote.datasource.diary.DiaryDataSource
import com.daily.data.remote.datasource.diary.DiaryDataSourceImpl
import com.daily.data.remote.datasource.email.EmailDataSource
import com.daily.data.remote.datasource.email.EmailDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {
    @Binds
    fun bindsAuthDataSource(
        authDataSourceImpl: AuthDataSourceImpl
    ): AuthDataSource

    @Binds
    fun bindsEmailDataSource(
        emailDataSourceImpl: EmailDataSourceImpl
    ): EmailDataSource

    @Binds
    fun bindsAccountDataSource(
        accountDataSourceImpl: AccountDataSourceImpl
    ): AccountDataSource

    @Binds
    fun bindsDiaryDataSource(
        diaryDataSourceImpl: DiaryDataSourceImpl
    ): DiaryDataSource
}