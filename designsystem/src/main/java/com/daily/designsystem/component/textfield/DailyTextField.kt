package com.daily.designsystem.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.daily.designsystem.theme.Body2
import com.daily.designsystem.theme.DailyTheme

@Composable
fun DailyTextField(
    modifier: Modifier = Modifier,
    value: String,
    enabled: Boolean = true,
    hint: String,
    textColor: Color = DailyTheme.color.Black,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    textStyle: TextStyle = DailyTheme.typography.body1,
    focusColor: Color = DailyTheme.color.Primary20,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit
) {
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    var isFocus by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = DailyTheme.color.Primary5,
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = if (isFocus) DailyTheme.color.Primary20 else Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 16.dp, vertical = 18.dp)
            .focusRequester(focusRequester)
            .onFocusChanged { isFocus = it.isFocused },
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        textStyle = mergedTextStyle,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        cursorBrush = SolidColor(focusColor),
        decorationBox = { innerTextField ->
            Box(modifier = modifier.fillMaxWidth()) {
                if (value.isEmpty()) {
                    Body2(
                        text = hint,
                        textColor = DailyTheme.color.Neutral40,
                        maxLines = maxLines
                    )
                }
                innerTextField()
            }
        }
    )
}
