package com.simplify.simplify.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.simplify.simplify.ui.theme.Black

@Composable
fun SimplifyText(text: Int, style: TextStyle, color: Color = Color.Black) {
    Text(text = stringResource(text), style = style, color = color)
}