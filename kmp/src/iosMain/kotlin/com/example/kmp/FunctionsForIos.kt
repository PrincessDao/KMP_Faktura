package com.example.kmp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalForeignApi::class, ExperimentalNativeApi::class)
@CName("callComposableFunction")
fun callComposableFunction(
    functionName: String,
    args: Map<String, Any> = emptyMap()
): UIViewController {
    return ComposeUIViewController {
        when (functionName) {
            "Padding" -> ComposeFunctions.Padding(
                width = args["width"] as Dp,
                height = args["height"] as Dp,
                backgroundColor = args["color"] as Color,
                visibility = args["alpha"] as Float
            )
            "Button" -> ComposeFunctions.Button(
                text = args["text"] as String,
                color = args["color"] as Color
            )
            else -> error("Unknown function: $functionName")
        }
    }
}