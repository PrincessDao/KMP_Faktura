package com.example.kmp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalNativeApi

internal fun initFramework() {
    callComposableFunction("")
}

@OptIn(ExperimentalForeignApi::class, ExperimentalNativeApi::class)
@CName("callComposableFunction")
fun callComposableFunction(
    functionName: String,
    args: Map<String, Any> = emptyMap()
): UIViewController {
    return ComposeUIViewController {
        when (functionName) {
            "Padding" -> ComposeFunctions.Padding(
                width = (args["width"] as? Number)?.toFloat()?.dp ?: DefaultPaddingWidth.current,
                height = (args["height"] as? Number)?.toFloat()?.dp ?: DefaultPaddingHeight.current,
                backgroundColor = when (val color = args["color"]) {
                    is String -> parseColor(color)
                    else -> DefaultPaddingBackgroundColor.current
                },
                visibility = (args["alpha"] as? Number)?.toFloat() ?: DefaultPaddingVisibility.current
            )
            "Button" -> ComposeFunctions.Button(
                text = args["text"] as? String ?: "Default",
                color = when (val color = args["color"]) {
                    is String -> parseColor(color)
                    else -> DefaultPaddingBackgroundColor.current
                }
            )
            else -> error("Unknown function: $functionName")
        }
    }
}

fun parseColor(color: String): Color {
    return when (color.lowercase()) {
        "red" -> Color.Red
        "green" -> Color.Green
        "blue" -> Color.Blue
        "black" -> Color.Black
        "white" -> Color.White
        "gray" -> Color.Gray
        else -> Color.Gray
    }
}