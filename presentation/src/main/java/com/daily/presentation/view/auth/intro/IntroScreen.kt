package com.daily.presentation.view.auth.intro

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daily.designsystem.component.DailyButton
import com.daily.designsystem.theme.*
import com.daily.presentation.R

@Composable
fun IntroScreen(
    modifier: Modifier = Modifier,
    navigateToSignIn: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }

    val offsetAnimation by animateDpAsState(
        targetValue = if (visible) (-24).dp else 240.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    LaunchedEffect(Unit) { visible = true }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .paint(
                painter = painterResource(id = R.drawable.bg_intro),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color(0x33000000), BlendMode.Darken)
            )
            .systemBarsPadding()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 135.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_daily),
                contentDescription = null,
                modifier = modifier.offset(y = offsetAnimation),
            )
            Subtitle1(
                text = stringResource(R.string.description_title),
                textColor = DailyTheme.color.White
            )
            Spacer(modifier = modifier.height(16.dp))
            Body1(
                text = stringResource(R.string.description_subtitle),
                textAlign = TextAlign.Center,
                textColor = DailyTheme.color.White
            )
        }
        Spacer(modifier = modifier.weight(1f))
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 114.dp)
        ) {
            DailyButton(
                text = stringResource(R.string.sign_up),
                modifier = modifier.fillMaxWidth(),
                onClick = { navigateToSignUp() }
            )
            Spacer(modifier = modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Caption1(
                    text = stringResource(R.string.already_have_an_account),
                    textColor = DailyTheme.color.White
                )
                Spacer(modifier = modifier.width(8.dp))
                Caption2(
                    text = stringResource(R.string.login),
                    textColor = DailyTheme.color.Primary20,
                    rippleEnabled = false,
                    onClick = { navigateToSignIn() }
                )
            }
        }
    }
}