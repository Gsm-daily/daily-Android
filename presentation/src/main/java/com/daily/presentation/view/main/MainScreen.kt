package com.daily.presentation.view.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daily.designsystem.component.calendar.DailyCalendar
import com.daily.presentation.R

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_autumn), // TODO: 받아온 계절에 맞게 변경
                contentScale = ContentScale.Crop
            )
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        DailyCalendar(
            modifier = Modifier.padding(horizontal = 14.dp),
            onDayClick = { /* TODO: 해당 날짜의 Diary로 이동 */ }
        )
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
