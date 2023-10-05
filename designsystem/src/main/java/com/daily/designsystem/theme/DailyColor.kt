package com.daily.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object DailyColor {
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)
    val Error = Color(0xFFD80505)
    val Background = Color(0xFFF9F9F9)

    val Shadow = Color(0x71717129)

    val Hint = Color(0xFF8F8F8F)

    val Primary5 = Color(0xFFFFF5F7)
    val Primary10 = Color(0xFFFFC7D8)
    val Primary20 = Color(0xFFFF5F8F)
    val Primary30 = Color(0xFFCC4C72)

    val Neutral10 = Color(0xFFF8F6F6)
    val Neutral20 = Color(0xFFE3D9D9)
    val Neutral30 = Color(0xFFD7C9C9)
    val Neutral40 = Color(0xFF977272)
    val Neutral50 = Color(0xFF6C5050)

    object FeatureColor {
        val CalendarWeekColor = Color(0x331C1C1E)
        val CalendarDayColor = Color(0xFF1C1C1E)
        val AnotherMonthColor = Color(0x801C1C1E)

        val KakaoContainerColor = Color(0xFFFEE500)
        val KakaoLabelColor = Color(0xD9000000)

        val BottomSheetColor = Color(0xB8FFFFFF)
    }
}

internal val LocalColor = staticCompositionLocalOf { DailyColor }
