package com.daily.data.remote.network

import com.daily.data.BuildConfig
import com.daily.data.local.datasource.LocalDataSource
import com.daily.data.remote.util.convertDateFormat
import com.daily.domain.exception.LoginRequiredException
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.time.LocalDateTime
import javax.inject.Inject

class RequestInterceptor @Inject constructor(
    private val localDataSource: LocalDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath
        val ignorePath = listOf("/auth", "/account/password", "/email")

        ignorePath.forEach {
            if (path.contains(it)) {
                return chain.proceed(request)
            }
        }

        val accessToken = runBlocking { localDataSource.getAccessToken().first() }
        val refreshToken = runBlocking { localDataSource.getRefreshToken().first() }
        val currentTime = LocalDateTime.now()
        val accessTokenExpiredAt = runBlocking { convertDateFormat(localDataSource.getAccessTokenExpiredAt().first()) }
        val refreshTokenExpiredAt = runBlocking { convertDateFormat(localDataSource.getRefreshTokenExpiredAt().first()) }

        if (currentTime.isAfter(refreshTokenExpiredAt)) throw LoginRequiredException()

        if (currentTime.isAfter(accessTokenExpiredAt)) {
            val client = OkHttpClient()
            val reissueRequest = Request.Builder()
                .url("${BuildConfig.BASE_URL}/api/v1/auth/reissue")
                .patch(JsonObject().toString().toRequestBody("application/json".toMediaTypeOrNull()))
                .addHeader(
                    "refreshToken",
                    "Bearer $refreshToken"
                )
                .build()
            val jsonParser = JsonParser()
            val response = client.newCall(reissueRequest).execute()
            if (response.isSuccessful) {
                val token = jsonParser.parse(response.body!!.string()) as JsonObject
                runBlocking {
                    localDataSource.saveToken(
                        token["accessToken"].toString(),
                        token["refreshToken"].toString(),
                        token["accessTokenExpiredAt"].toString(),
                        token["refreshTokenExpiredAt"].toString()
                    )
                }
            } else throw LoginRequiredException()
        }

        return chain.proceed(
            request.newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()
        )
    }
}