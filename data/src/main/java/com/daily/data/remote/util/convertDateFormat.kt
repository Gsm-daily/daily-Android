package com.daily.data.remote.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun convertDateFormat(input: String): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss")
    return LocalDateTime.parse(input, formatter)
}