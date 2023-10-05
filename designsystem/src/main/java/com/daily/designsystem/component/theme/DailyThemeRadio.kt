package com.daily.designsystem.component.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daily.designsystem.R
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.DailyColor

enum class Theme {
    GRASSLAND, OCEAN
}

@Composable
fun DailyThemeRadio(
    modifier: Modifier = Modifier,
    theme: Theme,
    selected: Boolean = false
) {
    val themeRes = when (theme) {
        Theme.GRASSLAND -> R.drawable.bg_grassland
        Theme.OCEAN -> R.drawable.bg_ocean
    }

    Image(
        modifier = modifier
            .size(width = 150.dp, height = 60.dp)
            .background(color = DailyColor.White, shape = RoundedCornerShape(14.dp))
            .border(
                width = 1.dp,
                color = if (selected) DailyColor.Primary20 else Color.Transparent,
                shape = RoundedCornerShape(14.dp)
            ),
        painter = painterResource(id = themeRes),
        contentDescription = "theme"
    )
}

@Preview
@Composable
fun DailyThemeRadioPreview() {
    var selected by remember { mutableStateOf("") }

    Row {
        DailyThemeRadio(
            modifier = Modifier.dailyClickable { selected = "GRASSLAND" },
            theme = Theme.GRASSLAND,
            selected = selected == "GRASSLAND"
        )
        DailyThemeRadio(
            modifier = Modifier.dailyClickable { selected = "OCEAN" },
            theme = Theme.OCEAN,
            selected = selected == "OCEAN"
        )
    }
}
