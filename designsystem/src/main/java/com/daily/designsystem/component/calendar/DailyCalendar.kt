package com.daily.designsystem.component.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.DailyColor
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.IcLeft
import com.daily.designsystem.theme.IcRight
import java.time.LocalDate

@Composable
fun DailyCalendar(
    modifier: Modifier = Modifier,
    onClickItem: (day: Int) -> Unit
) {
    var selectedDay by remember { mutableStateOf(LocalDate.now()) }

    Column(modifier = modifier.fillMaxWidth()) {
        CalendarTopBar(
            month = selectedDay.month.name,
            showPreviousMonth = { selectedDay = selectedDay.minusMonths(1) },
            showNextMonth = { selectedDay = selectedDay.plusMonths(1) }
        )
        Spacer(modifier = modifier.height(20.dp))
        DayOfWeekBar()
        Spacer(modifier = modifier.height(3.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            userScrollEnabled = false,
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(selectedDay.getMonthDays()) { dayOfMonth ->
                DayItem(selectedDay = selectedDay, monthDays = dayOfMonth, onClickItem = onClickItem)
            }
        }
    }
}

@Composable
private fun CalendarTopBar(
    month: String,
    showPreviousMonth: () -> Unit,
    showNextMonth: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = month,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier
                .weight(5f)
                .padding(start = 20.dp)
        )
        IcLeft(
            contentDescription = "previous",
            modifier = Modifier
                .weight(1f)
                .dailyClickable(rippleEnable = false) {
                    showPreviousMonth()
                }
        )
        IcRight(
            contentDescription = "next",
            modifier = Modifier
                .weight(1f)
                .dailyClickable(rippleEnable = false) {
                    showNextMonth()
                }
        )
    }
}

private val dayOfWeeks = listOf("S", "M", "T", "W", "T", "F", "S")

@Composable
private fun DayOfWeekBar() {
    Row(modifier = Modifier.fillMaxWidth()) {
        repeat(dayOfWeeks.size) { index ->
            Text(
                text = dayOfWeeks[index],
                color = DailyColor.FeatureColor.CalendarWeekColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun DayItem(
    selectedDay: LocalDate,
    monthDays: MonthDay,
    onClickItem: (day: Int) -> Unit
) {
    val isToday = LocalDate.now().isEqual(LocalDate.of(selectedDay.year, monthDays.month, monthDays.day))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .padding(9.dp)
            .background(
                color = if (isToday) DailyTheme.color.Black else Color.Transparent,
                shape = RoundedCornerShape(12.dp),
            )
            .dailyClickable(rippleEnable = false) {
                onClickItem(monthDays.day)
            }
    ) {
        val isAnotherMonth = LocalDate.now().monthValue != monthDays.month
        val textColor = when {
            isToday -> DailyColor.White
            isAnotherMonth -> DailyColor.FeatureColor.AnotherMonthColor
            else -> DailyColor.FeatureColor.CalendarDayColor
        }

        Text(
            text = monthDays.day.toString(),
            color = textColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = if (isAnotherMonth) 14.sp else 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}