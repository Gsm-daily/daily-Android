package com.daily.presentation.view.auth.select_theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.daily.designsystem.component.DailyButton
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.IcBack
import com.daily.presentation.R
import com.daily.presentation.viewmodel.account.AccountViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectThemeScreen(
    modifier: Modifier = Modifier,
    viewModel: AccountViewModel = hiltViewModel(),
    navigateToPrevious: () -> Unit
) {
    val pagerState = rememberPagerState()

    Column(modifier = modifier.systemBarsPadding()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            IcBack(
                contentDescription = "back",
                tint = DailyTheme.color.Black,
                modifier = modifier
                    .dailyClickable(rippleEnable = false) { navigateToPrevious() }
                    .align(Alignment.CenterStart)
            )
            Text(
                text = stringResource(R.string.select_theme),
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                modifier = modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = modifier.height(16.dp))
        ThemeField(pagerState = pagerState)
        Spacer(modifier = modifier.height(26.dp))
        DailyButton(
            text = stringResource(if (pagerState.currentPage == 0) R.string.select_grassland else R.string.select_ocean),
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            viewModel.choiceTheme(if (pagerState.currentPage == 0) "GRASSLAND" else "OCEAN")
        }
    }
}