package com.daily.designsystem.component.calendar

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

private const val DAYS_IN_WEEK = 7

fun LocalDate.getDaysOfMonth(): List<LocalDate> {
    val daysOfMonth = mutableListOf<LocalDate>()
    val startOfMonth = this.withDayOfMonth(1)
    val endOfMonth = this.withDayOfMonth(this.lengthOfMonth())

    val firstSunday = startOfMonth.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))

    daysOfMonth.addAll((0 until startOfMonth.dayOfWeek.value % DAYS_IN_WEEK).map {
        firstSunday.plusDays(it.toLong())
    })

    daysOfMonth.addAll((1..this.lengthOfMonth()).map {
        this.withDayOfMonth(it)
    })

    daysOfMonth.addAll((1..(DAYS_IN_WEEK * 6) - daysOfMonth.size).map {
        endOfMonth.plusDays(it.toLong())
    })

    return daysOfMonth
}
