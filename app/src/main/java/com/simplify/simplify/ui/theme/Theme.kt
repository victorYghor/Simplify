package com.simplify.simplify.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val LightDefaultColorScheme = lightColorScheme(
    primary = Blue800,
    onPrimary = Color.White,
    secondary = Purple800,
    onSecondary = Color.White
)

@Composable
fun SymplifyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = LightDefaultColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography =
    ) {

    }
}



