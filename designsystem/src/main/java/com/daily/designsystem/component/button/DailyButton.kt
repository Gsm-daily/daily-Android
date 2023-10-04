package com.daily.designsystem.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = DailyTheme.color.Primary20,
        disabledContainerColor = DailyTheme.color.Primary10
    ),
    contentPadding: PaddingValues = PaddingValues(vertical = 20.dp),
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        colors = colors,
        shape = RoundedCornerShape(20.dp),
        contentPadding = contentPadding,
        enabled = enabled,
        onClick = onClick
    ) {
        Subtitle1(
            text = text,
            textColor = DailyTheme.color.White,
            textAlign = TextAlign.Center
        )
    }
}
