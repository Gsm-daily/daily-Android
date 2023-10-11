package com.daily.presentation.view.my_theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.IcBack
import com.daily.presentation.R

@Composable
fun MyThemeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .paint(
                painter = painterResource(id = R.drawable.bg_ocean_7),
                contentScale = ContentScale.Crop,
            )
            .systemBarsPadding()
    ) {
        Spacer(modifier = modifier.height(13.dp))
        IcBack(
            contentDescription = "back",
            modifier = modifier.dailyClickable(rippleEnable = false) {  }
        )
    }
}

@Preview
@Composable
fun MyThemeScreenPreview() {
    MyThemeScreen()
}
