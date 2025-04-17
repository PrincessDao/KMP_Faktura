package com.example.kmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp



    @Composable
    fun Padding(
        width: Dp = DefaultPaddingWidth.current,
        height: Dp = DefaultPaddingHeight.current,
        backgroundColor: Color = DefaultPaddingBackgroundColor.current,
        visibility: Float = DefaultPaddingVisibility.current,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(width, height)
                .background(color = backgroundColor.copy(alpha = visibility))
        ) {
        }
    }
