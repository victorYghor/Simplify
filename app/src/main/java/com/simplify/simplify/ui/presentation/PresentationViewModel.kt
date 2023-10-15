package com.simplify.simplify.ui.presentation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PresentationViewModel(val goToLogin: () -> Unit): ViewModel() {
    private val _slideNumber = MutableStateFlow(1)
    val slideNumber = _slideNumber.asStateFlow()

    fun goToNextSlide() {
        if(_slideNumber.value > 2) {
            goToLogin()
        } else {
            _slideNumber.update { it + 1 }
        }
    }

    fun updateSlideNumber(newNumber: Int) {
        if(newNumber > 3 || newNumber < 1) {
            Log.e("PresentationViewModel", "this number is not in the range")
        } else {
            _slideNumber.update {
                newNumber
            }
        }
    }
}

