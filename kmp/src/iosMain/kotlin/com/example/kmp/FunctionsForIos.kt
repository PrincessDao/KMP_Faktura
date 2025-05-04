package com.example.kmp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalNativeApi

internal fun initFramework() {
}

@OptIn(ExperimentalForeignApi::class, ExperimentalNativeApi::class)
@CName("callComposableFunction")
fun callComposableFunction(
    functionName: String,
    args: Map<String, Any> = emptyMap()
): UIViewController {
    println("Calling composable function: $functionName with args: $args")

    return ComposeUIViewController {
        when (functionName) {
            "Padding" -> {
                val width = (args["width"] as? Number)?.toFloat()?.dp ?: DefaultPaddingWidth.current
                val height = (args["height"] as? Number)?.toFloat()?.dp ?: DefaultPaddingHeight.current
                val backgroundColor = when (val color = args["color"]) {
                    is String -> parseColor(color)
                    else -> DefaultPaddingBackgroundColor.current
                }
                val visibility = (args["alpha"] as? Number)?.toFloat() ?: DefaultPaddingVisibility.current

                println("Padding params -> width: $width, height: $height, color: $backgroundColor, alpha: $visibility")

                ComposeFunctions.Padding(
                    width = width,
                    height = height,
                    backgroundColor = backgroundColor,
                    visibility = visibility
                )
            }
            "Button" -> {
                val text = args["text"] as? String ?: "Default"
                val color = when (val color = args["color"]) {
                    is String -> parseColor(color)
                    else -> DefaultPaddingBackgroundColor.current
                }

                println("Button params -> text: $text, color: $color")

                ComposeFunctions.Button(
                    text = text,
                    color = color
                )
            }
            else -> {
                println("Unknown function: $functionName")
                error("Unknown function: $functionName")
            }
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