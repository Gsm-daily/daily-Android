package com.daily.data.remote.util

import com.daily.domain.exception.*
import retrofit2.HttpException

suspend fun <T> safeApiCall(call: suspend () -> T): T {
    return try {
        call.invoke()
    } catch (e: HttpException) {
        val message = e.message
        throw when (e.code()) {
            400 -> BadRequestException(message)
            401 -> UnauthorizedException(message)
            403 -> ForbiddenException(message)
            404 -> NotFoundException(message)
            409 -> ConflictException(message)
            else -> OtherHttpException(
                code = e.code(),
                message = message
            )
        }
    } catch (e: Exception) {
        throw UnknownException(message = e.message)
    }
}