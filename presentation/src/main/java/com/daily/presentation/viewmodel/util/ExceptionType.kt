package com.daily.presentation.viewmodel.util

sealed interface ExceptionType {
    object BadRequestException: ExceptionType
    object UnauthorizedException: ExceptionType
    object ForbiddenException: ExceptionType
    object NotFoundException: ExceptionType
    object ConflictException: ExceptionType
    object ServerException: ExceptionType
    object UnknownException: ExceptionType
}