package com.simplify.simplify.ui.components

import android.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

@Composable
fun SimplifyText(text: Int, style: TextStyle) {
    Text(text = stringResource(text), style = style)
}