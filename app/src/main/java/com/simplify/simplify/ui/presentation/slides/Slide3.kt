package com.simplify.simplify.ui.presentation.slides

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.SimplifyText

@Composable
fun Slide3(innerPadding: PaddingValues) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(8.dp)
    ) {
        SimplifyText(text = R.string.schedule_of_events, style = typography.titleLarge)
        SimplifyText(text = R.string.visualize_the_events_in_your_city, style = typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun Slide3Preview() {
    Slide3(innerPadding = PaddingValues())
}