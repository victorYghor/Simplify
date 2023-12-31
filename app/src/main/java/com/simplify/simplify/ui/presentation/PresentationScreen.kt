package com.simplify.simplify.ui.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.simplify.simplify.ui.presentation.slides.Slide1
import com.simplify.simplify.ui.presentation.slides.Slide2
import com.simplify.simplify.ui.presentation.slides.Slide3

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun PresentationScreen(
    onComplete: () -> Unit,
) {

    val sliderState = rememberPagerState(pageCount = {
        3
    })

    Scaffold(
        bottomBar = {
            BottomBarSlide (
                slideNumber = sliderState.currentPage,
                slideState = sliderState,
                onComplete = onComplete
            )
        }
    ) { innerPadding ->
        HorizontalPager(sliderState) { page ->
            when(page) {
                0 -> Slide1(innerPadding)
                1 -> Slide2(innerPadding)
                2 -> Slide3(innerPadding) { onComplete() }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PresentationScreenPreview() {
    PresentationScreen(onComplete = {})
}