package com.daily.designsystem.component.calendar

import java.time.LocalDate

object CalendarConstants {
    const val SUNDAY = 7
    const val SATURDAY = 6
    const val MAX_ITEM_COUNT = 42
}

data class MonthDay(
    val month: Int,
    val day: Int
)

fun LocalDate.getMonthDays(): List<MonthDay> {
    val monthDays = mutableListOf<MonthDay>()

    val startOfMonth = LocalDate.of(year, monthValue, 1)
    val endOfMonth = LocalDate.of(year, monthValue, lengthOfMonth())

    val startDayOfWeek = startOfMonth.dayOfWeek.value
    val endDayOfWeek = endOfMonth.dayOfWeek.value

    val startDayOfWeekData = if (startDayOfWeek == CalendarConstants.SUNDAY) 0 else startDayOfWeek
    val endDayOfWeekData = when (endDayOfWeek) {
        CalendarConstants.SUNDAY -> 6
        CalendarConstants.SATURDAY -> 0
        else -> 6 - endDayOfWeek
    }

    monthDays.addAll(startOfMonth.getPreviousDays(1..startDayOfWeekData).map {
        MonthDay(month = it.monthValue, day = it.dayOfMonth)
    })

    monthDays.addAll((1..lengthOfMonth()).map { MonthDay(month = startOfMonth.monthValue, it) })

    monthDays.addAll(endOfMonth.getAfterDays(1..endDayOfWeekData).map {
        MonthDay(month = it.monthValue, day = it.dayOfMonth)
    })

    if (monthDays.size < CalendarConstants.MAX_ITEM_COUNT) {
        val lastDay = LocalDate.of(year, monthDays.last().month, monthDays.last().day)

        repeat(7) { count ->
            val date = lastDay.plusDays(count.toLong() + 1)

            monthDays.add(MonthDay(month = date.monthValue, day = date.dayOfMonth))
        }
    }
    return monthDays
}

fun LocalDate.getPreviousDays(range: IntRange) = range.map { minusDays(it.toLong()) }

fun LocalDate.getAfterDays(range: IntRange) = range.map { plusDays(it.toLong()) }