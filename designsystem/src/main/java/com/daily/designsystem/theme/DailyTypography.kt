package com.daily.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.daily.designsystem.R

val notosanskr = FontFamily(
    Font(R.font.notosanskr_black, FontWeight.Black),
    Font(R.font.notosanskr_bold, FontWeight.Bold),
    Font(R.font.notosanskr_light, FontWeight.Light),
    Font(R.font.notosanskr_thin, FontWeight.Thin),
    Font(R.font.notosanskr_medium, FontWeight.Medium),
    Font(R.font.notosanskr_regular, FontWeight.Normal)
)

object DailyTypography {
    val h1 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    )
    val subtitle1 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    val body1 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 1.5f.sp
    )
    val body2 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    val body3 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 1.3f.sp
    )
    val caption1 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    val caption2 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Bold,
    )
}

internal val LocalTypography = staticCompositionLocalOf { DailyTypography }