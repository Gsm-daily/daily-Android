package com.daily.di

import com.daily.data.remote.datasource.auth.AuthDataSource
import com.daily.data.remote.datasource.auth.AuthDataSourceImpl
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
}