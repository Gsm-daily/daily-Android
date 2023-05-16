package com.daily.designsystem.component.navbar

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.theme.DailyTheme

@Composable
fun RowScope.DailyNavItem(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean,
    enabled: Boolean = true,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val color = if (selected) DailyTheme.color.Primary30 else DailyTheme.color.Neutral30

    CompositionLocalProvider(
        LocalContentColor provides color
    ) {
        Box(
            modifier = modifier
                .selectable(
                    selected = selected,
                    interactionSource = interactionSource,
                    indication = null,
                    enabled = enabled,
                    role = Role.Tab,
                    onClick = onClick
                )
                .weight(1f)
        ) {
            Layout({
                Box(Modifier.layoutId("icon")) { icon() }
                Box(Modifier.layoutId("label")) {
                    Text(
                        text = label,
                        color = color,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }) { measurable, constraints ->
                val iconPlaceable = measurable.first { it.layoutId == "icon" }.measure(constraints)
                val textPlaceable = measurable.first { it.layoutId == "label" }.measure(constraints)

                val width = constraints.maxWidth
                val height = constraints.maxHeight

                val iconX = (width - iconPlaceable.width) / 2
                val textX = (width - textPlaceable.width) / 2

                val iconY = 2.dp.roundToPx()
                val textY = iconY + 32.dp.roundToPx()

                layout(width, height) {
                    textPlaceable.placeRelative(textX, textY)
                    iconPlaceable.placeRelative(iconX, iconY)
                }
            }
        }
    }
}