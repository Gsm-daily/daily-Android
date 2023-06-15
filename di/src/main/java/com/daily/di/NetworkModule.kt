package com.daily.di

import com.daily.data.remote.network.RequestInterceptor
import com.daily.data.remote.network.api.AccountApi
import com.daily.data.remote.network.api.AuthApi
import com.daily.data.remote.network.api.DiaryApi
import com.daily.data.remote.network.api.EmailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideEmailService(retrofit: Retrofit): EmailApi =
        retrofit.create(EmailApi::class.java)

    @Provides
    @Singleton
    fun provideAccountService(retrofit: Retrofit): AccountApi =
        retrofit.create(AccountApi::class.java)

    @Provides
    @Singleton
    fun provideDiaryService(retrofit: Retrofit): DiaryApi =
        retrofit.create(DiaryApi::class.java)

    @Provides
    @Singleton
    fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        requestInterceptor: RequestInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(requestInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }
}