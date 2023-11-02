package com.simplify.simplify.ui.presentation.slides

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.SimplifyText

@Composable
fun Slide3(innerPadding: PaddingValues, onComplete: () -> Unit, offset: Float) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(8.dp)
    ) {
        SimplifyText(text = R.string.schedule_of_events, style = typography.titleLarge)
        SimplifyText(
            text = R.string.visualize_the_events_in_your_city,
            style = typography.bodyMedium
        )
        Text(offset.toString())

        LaunchedEffect(offset < -250f) {
            Log.i("Slide3", "OnCompleteCalled")
            onComplete()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Slide3Preview() {
    Slide3(innerPadding = PaddingValues(), onComplete = {}, offset = 1f)
}