package com.daily.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object DailyColor {
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)
    val Error = Color(0xFFD80505)

    val Primary5 = Color(0xFFFFF5F7)
    val Primary10 = Color(0xFFFFC7D8)
    val Primary20 = Color(0xFFFF5F8F)
    val Primary30 = Color(0xFFCC4C72)

    val Neutral10 = Color(0xFFF8F6F6)
    val Neutral20 = Color(0xFFE3D9D9)
    val Neutral30 = Color(0xFFD7C9C9)
    val Neutral40 = Color(0xFF977272)
    val Neutral50 = Color(0xFF6C5050)
}

internal val LocalColor = staticCompositionLocalOf { DailyColor }