@file:OptIn(ExperimentalObjCName::class)

package com.example.kmp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalNativeApi
import kotlin.experimental.ExperimentalObjCName

fun parseColorHex(hex: String): Color {
    val cleanHex = hex.removePrefix("#")
    val colorLong = cleanHex.toLong(16)

    return when (cleanHex.length) {
        6 -> { // RRGGBB
            val r = ((colorLong shr 16) and 0xFF).toInt()
            val g = ((colorLong shr 8) and 0xFF).toInt()
            val b = (colorLong and 0xFF).toInt()
            Color(red = r / 255f, green = g / 255f, blue = b / 255f)
        }
        8 -> { // AARRGGBB
            val a = ((colorLong shr 24) and 0xFF).toInt()
            val r = ((colorLong shr 16) and 0xFF).toInt()
            val g = ((colorLong shr 8) and 0xFF).toInt()
            val b = (colorLong and 0xFF).toInt()
            Color(red = r / 255f, green = g / 255f, blue = b / 255f, alpha = a / 255f)
        }
        else -> throw IllegalArgumentException("Invalid color hex: $hex")
    }
}

@ObjCName("dotPersonalOfferViewController")
fun DotPersonalOfferViewController(
    totalDots: Int = 5,
    unselectedColorHex: String = "#СССССС",
    selectedColorHex: String = "#FF00000"
): UIViewController = ComposeUIViewController {
    DotPersonalOffer(
        totalDots = totalDots,
        unselectedColor = parseColorHex(unselectedColorHex),
        selectedColor = parseColorHex(selectedColorHex)

    )
}
@ObjCName("dotBannerViewController")
fun DotBannerViewController(
    totalDots: Int = 5,
    currentIndex: Int = 0,
    unselectedColorHex: String = "#СССССС",
    selectedColorHex: String = "#FF00000"
): UIViewController = ComposeUIViewController {
    DotBanner(
        totalDots = totalDots,
        currentIndex = currentIndex,
        unselectedColor = parseColorHex(unselectedColorHex),
        selectedColor = parseColorHex(selectedColorHex)
    ) }