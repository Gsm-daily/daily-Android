package com.daily.presentation.view.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daily.designsystem.component.calendar.DailyCalendar
import com.daily.presentation.R
import com.daily.presentation.viewmodel.main.MainViewModel
import com.daily.presentation.viewmodel.util.UiState

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getSeason()
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is UiState.Success -> {
            val background = when (state.data!!.season) {
                "SPRING" -> R.drawable.bg_spring
                "SUMMER" -> R.drawable.bg_summer
                "AUTUMN" -> R.drawable.bg_autumn
                "WINTER" -> R.drawable.bg_winter
                else -> null
            }

            background?.let {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .paint(
                            painter = painterResource(id = R.drawable.bg_autumn),
                            contentScale = ContentScale.Crop
                        )
                        .systemBarsPadding()
                ) {
                    Spacer(modifier = modifier.height(182.dp))
                    DailyCalendar(onDayClick = { })
                    Spacer(modifier = modifier.weight(1f))
                }
            }
        }
        is UiState.Error -> TODO()
        UiState.Loading -> TODO()
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
