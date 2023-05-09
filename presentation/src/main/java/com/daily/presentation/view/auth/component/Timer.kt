package com.daily.presentation.view.auth.component

import androidx.compose.runtime.Composable
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.H0

@Composable
fun Timer(duration: Long) {
    val min = duration / 60
    val sec = (duration % 60).let { if (it / 10 == 0L) "0$it" else it }

    H0(
        text = "$min : $sec",
        textColor = DailyTheme.color.Black
    )
}