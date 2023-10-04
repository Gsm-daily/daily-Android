package com.daily.presentation.view.auth.select_theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ThemeField(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    Column {
//        TODO: 변경된 디자인에 맞게 수정
//        HorizontalPager(
//            pageCount = PAGE_COUNT,
//            state = pagerState,
//            pageSize = PageSize.Fixed(247.dp),
//            contentPadding = PaddingValues(horizontal = 64.dp),
//            pageSpacing = 32.dp
//        ) { page ->
//            val (image, description) = when (page) {
//                0 -> Pair(R.drawable.bg_grassland7, "grassland")
//                1 -> Pair(R.drawable.bg_ocean7, "ocean")
//                else -> Pair(null, null)
//            }
//
//            image?.let {
//                val pageOffset = (
//                        (pagerState.currentPage - page) + pagerState
//                            .currentPageOffsetFraction
//                        ).absoluteValue
//
//                Image(
//                    painter = painterResource(id = it),
//                    contentDescription = description,
//                    modifier = modifier
//                        .size(247.dp, 534.dp)
//                        .clip(RoundedCornerShape(24.dp)),
//                    colorFilter = ColorFilter.tint(
//                        Color(
//                            0f, 0f, 0f, lerp(
//                                start = 0f,
//                                stop = 0.3f,
//                                fraction = pageOffset.coerceIn(0f, 1f)
//                            )
//                        ),
//                        BlendMode.Darken
//                    )
//                )
//            }
//        }
//        Spacer(modifier = modifier.height(24.dp))
//        Row(
//            modifier = modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            repeat(PAGE_COUNT) {
//                val color = if (pagerState.currentPage == it) DailyTheme.color.Neutral50 else DailyTheme.color.Neutral20
//                Box(
//                    modifier = modifier
//                        .padding(horizontal = 4.dp)
//                        .clip(CircleShape)
//                        .background(color)
//                        .size(6.dp)
//                )
//            }
//        }
    }
}
