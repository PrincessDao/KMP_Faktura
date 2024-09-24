package org.example.kmp

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF81a7fc),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF0056b3),
    onPrimaryContainer = Color.White,
    onError = Color.White,
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF4b4a4f),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF4b4a4f)
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = SfProDisplayTypography(),
        content = content
    )
}