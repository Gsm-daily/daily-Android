package com.daily.data.remote.network

import com.daily.data.local.datasource.LocalDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor(
    private val localDataSource: LocalDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url().encodedPath()
        val ignorePath = listOf("/auth", "/account/password", "/email")

        ignorePath.forEach {
            if (path.contains(it)) {
                return chain.proceed(request)
            }
        }

        val accessToken = runBlocking { localDataSource.getAccessToken().first() }

        return chain.proceed(
            request.newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()
        )
    }
}