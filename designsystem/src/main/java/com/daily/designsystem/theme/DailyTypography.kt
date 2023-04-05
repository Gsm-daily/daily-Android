package com.daily.designsystem.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.daily.designsystem.R
import com.daily.designsystem.modifier.dailyClickable

val notosanskr = FontFamily(
    Font(R.font.notosanskr_black, FontWeight.Black),
    Font(R.font.notosanskr_bold, FontWeight.Bold),
    Font(R.font.notosanskr_light, FontWeight.Light),
    Font(R.font.notosanskr_thin, FontWeight.Thin),
    Font(R.font.notosanskr_medium, FontWeight.Medium),
    Font(R.font.notosanskr_regular, FontWeight.Normal)
)

object DailyTypography {
    val h0 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val h1 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val subtitle0 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val subtitle1 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val body1 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = (16 * 1.5f).sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val body2 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val body3 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = (14 * 1.3f).sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val caption1 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    val caption2 = TextStyle(
        fontFamily = notosanskr,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
}

@Composable
fun H0(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.h0,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun H1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.h1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun Subtitle0(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.subtitle1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun Subtitle1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.subtitle1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun Body1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.body1,
        color = textColor,
        textAlign = textAlign,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun Body2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.body2,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}

@Composable
fun Body3(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.body3,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}
@Composable
fun Caption1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.caption1,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}
@Composable
fun Caption2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DailyTheme.color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null,
    rippleEnabled: Boolean = true,
    rippleColor: Color = Color.Unspecified,
    bounded: Boolean = true
) {
    Text(
        modifier = modifier.dailyClickable(
            onClick = onClick,
            rippleColor = rippleColor,
            rippleEnable = rippleEnabled,
            bounded = bounded
        ),
        text = text,
        style = DailyTypography.caption2,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout
    )
}

internal val LocalTypography = staticCompositionLocalOf { DailyTypography }