package com.daily.di

import com.daily.data.local.datasource.LocalDataSource
import com.daily.data.local.datasource.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {
    @Binds
    fun bindsLocalDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource
}