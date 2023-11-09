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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.SimplifyText
import com.simplify.simplify.ui.theme.Blue800

// todo implement responsiveness, for screens of different sizes
@Composable
fun Slide2(innerPadding: PaddingValues) {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(innerPadding)
    ) {
        SimplifyText(text = R.string.events_are_better_with_friends, style = typography.titleSmall)
        Icon(
            painterResource(R.drawable.groups),
            contentDescription = null,
            modifier = Modifier.size(200.dp),
            tint = Blue800
        )
        SimplifyText(text = R.string.engage_in, style = typography.titleSmall)
        Icon(
            painterResource(R.drawable.people_speaking),
            contentDescription = null, modifier = Modifier.size(128.dp),
            tint = Blue800
        )
        SimplifyText(
            text = R.string.see_what_people_are_saying,
            style = typography.titleSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Slide2Preview() {
    Slide2(innerPadding = PaddingValues())
}