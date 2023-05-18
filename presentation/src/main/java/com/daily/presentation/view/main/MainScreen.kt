package com.daily.presentation.view.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daily.designsystem.component.calendar.DailyCalendar
import com.daily.presentation.R

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.bg_summer),
                contentScale = ContentScale.Crop
            )
            .systemBarsPadding()
    ) {
        Spacer(modifier = modifier.height(182.dp))
        DailyCalendar(onClickItem = { })
        Spacer(modifier = modifier.weight(1f))
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}