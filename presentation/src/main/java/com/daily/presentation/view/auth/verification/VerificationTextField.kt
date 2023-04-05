package com.daily.presentation.view.auth.verification

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.H1

@Composable
fun VerificationTextField(
    modifier: Modifier = Modifier,
    value: String,
    length: Int,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(length) { index ->
                    val isFocused = value.length == index + 1

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = modifier
                            .size(60.dp)
                            .background(
                                color = DailyTheme.color.Primary5,
                                shape = RoundedCornerShape(20.dp),
                            )
                            .border(
                                width = 1.dp,
                                color = if (isFocused) DailyTheme.color.Primary20 else Color.Transparent,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clip(RoundedCornerShape(20.dp)),
                    ) {
                        H1(
                            text = value.getOrNull(index)?.toString() ?: "",
                            textColor = DailyTheme.color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                    if (index < length - 1) Spacer(modifier = modifier.width(16.dp))
                }
            }
        }
    )
}