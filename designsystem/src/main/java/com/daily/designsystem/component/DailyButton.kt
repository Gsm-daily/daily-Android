package com.daily.designsystem.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.theme.DailyTheme

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
        Text(
            text = text,
            modifier = modifier.padding(vertical = 10.dp),
            color = DailyTheme.color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
    }
}