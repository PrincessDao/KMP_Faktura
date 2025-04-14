package com.example.kmp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun paddingKMP(
    width: Float,
    height: Float,
    color: Long,
    visibility: Float
): UIViewController {
    return ComposeUIViewController {
        Padding(
            width = width.toDp(),
            height = height.toDp(),
            backgroundColor = Color(color),
            visibility = visibility
        )
    }
}