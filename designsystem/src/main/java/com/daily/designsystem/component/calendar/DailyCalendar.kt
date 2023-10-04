package com.daily.designsystem.component.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.DailyColor
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.IcLeft
import com.daily.designsystem.theme.IcRight
import java.time.LocalDate

private val dayOfWeeks = listOf("S", "M", "T", "W", "T", "F", "S")

@Composable
fun DailyCalendar(
    modifier: Modifier = Modifier,
    onDayClick: (day: LocalDate) -> Unit
) {
    var selectedDay by remember { mutableStateOf(LocalDate.now()) }

    Column(modifier = modifier.fillMaxWidth()) {
        CalendarTopBar(
            month = selectedDay.month.name,
            onLeftClick = { selectedDay = selectedDay.minusMonths(1) },
            onRightClick = { selectedDay = selectedDay.plusMonths(1) }
        )
        Spacer(modifier = modifier.height(20.dp))
        DayOfWeekBar()
        Spacer(modifier = modifier.height(3.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            userScrollEnabled = false,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(selectedDay.getDaysOfMonth()) { day ->
                DayItem(
                    selectedDay = selectedDay,
                    day = day,
                    onDayClick = onDayClick
                )
            }
        }
    }
}

@Composable
private fun CalendarTopBar(
    month: String,
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 11.dp, end = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = month,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.weight(1f)
        )
        IcLeft(
            contentDescription = "previous",
            modifier = Modifier.dailyClickable(
                rippleEnable = false,
                onClick = onLeftClick
            )
        )
        Spacer(modifier = Modifier.width(43.dp))
        IcRight(
            contentDescription = "next",
            modifier = Modifier.dailyClickable(
                rippleEnable = false,
                onClick = onRightClick
            )
        )
    }
}

@Composable
private fun DayOfWeekBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        dayOfWeeks.forEach {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = it,
                    color = DailyColor.FeatureColor.CalendarWeekColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun DayItem(
    selectedDay: LocalDate,
    day: LocalDate,
    onDayClick: (day: LocalDate) -> Unit
) {
    val isToday = LocalDate.now().isEqual(day)
    val isAnotherMonth = selectedDay.monthValue != day.monthValue

    Box(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .padding(4.dp)
            .background(
                color = if (isToday) DailyTheme.color.Black else Color.Transparent,
                shape = RoundedCornerShape(12.dp),
            )
            .dailyClickable(
                rippleEnable = false,
                onClick = { onDayClick(day) }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.dayOfMonth.toString(),
            color = when {
                isToday -> DailyColor.White
                isAnotherMonth -> DailyColor.FeatureColor.AnotherMonthColor
                else -> DailyColor.Black
            },
            fontWeight = FontWeight.SemiBold,
            fontSize = if (isAnotherMonth) 14.sp else 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun DailyCalendarPreview() {
    DailyCalendar(modifier = Modifier.background(DailyColor.White)) {}
}
