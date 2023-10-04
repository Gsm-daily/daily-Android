package com.daily.designsystem.component.navbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.daily.designsystem.component.util.DailyDimen
import com.daily.designsystem.theme.DailyTheme

@Composable
fun DailyNavBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = DailyTheme.color.White,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(DailyDimen.NavBarHeight)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}
