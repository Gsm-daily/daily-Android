package com.daily.presentation.view.auth.intro

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.presentation.R

@Composable
fun IntroScreen(modifier: Modifier = Modifier) {
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
            Text(
                text = stringResource(R.string.description_title),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = modifier.height(16.dp))
            Text(
                text = stringResource(R.string.description_subtitle),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.White
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
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5F8F)),
                shape = RoundedCornerShape(20.dp),
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.sign_in),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = modifier.padding(vertical = 10.dp)
                )
            }
            Spacer(modifier = modifier.height(16.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White, fontSize = 16.sp)) {
                        append(stringResource(R.string.already_have_an_account))
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFF5F8F),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(stringResource(R.string.login))
                    }
                }
            )
        }
    }
}