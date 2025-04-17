package com.example.kmp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExportObjCClass
import platform.UIKit.UIViewController

@OptIn(BetaInteropApi::class)
@ExportObjCClass
@Suppress("unused")
object KMPViewController {
fun kmpPadding(
    width: Dp,
    height: Dp,
    color: Long,
    alpha: Float
): UIViewController = ComposeUIViewController {
    Padding(
        width = width,
        height = height,
        backgroundColor = Color(color),
        visibility = alpha
    )
}
    }


