package com.simplify.simplify.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightDefaultColorScheme = lightColorScheme(
    primary = Blue800,
    onPrimary = Color.White,
    secondary = Purple800,
    onSecondary = Color.White,
    background = Color.White,
    onBackground = Color.Black
)

@Composable
fun SimplifyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit
) {
    // you need to pass the content for your app work correctly
    val colorScheme = LightDefaultColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = simplifyTypography,
        shapes = Shapes(),
        content = content
    )
}



