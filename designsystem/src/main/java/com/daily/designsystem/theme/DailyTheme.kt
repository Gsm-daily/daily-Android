package com.daily.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun DailyTheme(
    color: DailyColor = DailyTheme.color,
    typography: DailyTypography = DailyTheme.typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColor provides color,
        LocalTypography provides typography
    ) {
        content()
    }
}

object DailyTheme {
    val color: DailyColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current
    val typography: DailyTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}