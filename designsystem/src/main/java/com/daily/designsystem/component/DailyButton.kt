package com.daily.designsystem.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.Subtitle1

@Composable
fun DailyButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = DailyTheme.color.Primary20,
            disabledContainerColor = DailyTheme.color.Primary10
        ),
        shape = RoundedCornerShape(20.dp),
        enabled = enabled
    ) {
        Subtitle1(
            text = text,
            modifier = modifier.padding(vertical = 10.dp),
            textColor = DailyTheme.color.White,
            textAlign = TextAlign.Center
        )
    }
}