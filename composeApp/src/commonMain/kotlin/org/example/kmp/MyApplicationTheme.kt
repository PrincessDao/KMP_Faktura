package org.example.kmp

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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

private val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = AppTypography,
        content = content
    )
}