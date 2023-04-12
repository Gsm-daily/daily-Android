package com.daily.presentation.viewmodel.util

import com.daily.domain.exception.*

fun Throwable.exceptionHandling(
    badRequestAction: () -> Unit = {},
    unauthorizedAction: () -> Unit = {},
    forbiddenAction: () -> Unit = {},
    notFoundAction: () -> Unit = {},
    conflictAction: () -> Unit = {},
    serverAction: () -> Unit = {},
    unknownAction: () -> Unit = {},
) {
    when (this) {
        is BadRequestException -> badRequestAction()
        is UnauthorizedException -> unauthorizedAction()
        is ForbiddenException -> forbiddenAction()
        is NotFoundException -> notFoundAction()
        is ConflictException -> conflictAction()
        is ServerException -> serverAction()
        else -> unknownAction()
    }
}
