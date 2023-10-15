package com.simplify.simplify.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.SimplifyText
import com.simplify.simplify.ui.theme.typography

@Composable
fun Slide1(innerPadding: Dp) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SimplifyText(R.string.welcome_msg, style = typography.titleMedium)
        Image(
            painterResource(R.drawable.symplify),
            contentDescription = stringResource(R.string.simplify_logo)
        )
        SimplifyText(R.string.app_name, typography.titleMedium)

    }
}