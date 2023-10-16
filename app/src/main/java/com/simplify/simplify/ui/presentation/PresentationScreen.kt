package com.simplify.simplify.ui.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.simplify.simplify.ui.presentation.slides.Slide1
import com.simplify.simplify.ui.presentation.slides.Slide2
import com.simplify.simplify.ui.presentation.slides.Slide3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PresentationScreen(
    viewModel: PresentationViewModel
) {

    val slideNumber by viewModel.slideNumber.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            BottomBarSlide (
                slideNumber = slideNumber,
                goToNextSlide = { viewModel.goToNextSlide() },
                updateSlide = {it: Int -> viewModel.updateSlideNumber(it)}
            )
        }
    ) { innerPadding ->
        when(slideNumber) {
            1 -> { Slide1(innerPadding) }
            2 -> { Slide2(innerPadding) }
            3 -> { Slide3(innerPadding) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PresentationScreenPreview() {
    val vm = PresentationViewModel({})
    PresentationScreen(vm)
}