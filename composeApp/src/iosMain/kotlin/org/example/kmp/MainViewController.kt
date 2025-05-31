@file:OptIn(ExperimentalObjCName::class)

package org.example.kmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmp.DotBanner
import com.example.kmp.Padding
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarManager
import platform.UIKit.UIWindow
import platform.UIKit.UIViewController
import platform.UIKit.UIColor
import platform.darwin.NSObject
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.kmp.DotPersonalOffer
import kotlin.experimental.ExperimentalObjCName

class IOSPlatformController(private val window: UIWindow?) : PlatformController {
    override fun setStatusBarColor(color: Int) {
        val uiColor = UIColor(
            red = ((color shr 16) and 0xFF).toDouble() / 255.0,
            green = ((color shr 8) and 0xFF).toDouble() / 255.0,
            blue = (color and 0xFF).toDouble() / 255.0,
            alpha = 1.0
        )
        window?.rootViewController?.view?.backgroundColor = uiColor
    }
}

@OptIn(ExperimentalForeignApi::class)
class IOSScreenSizeProvider : ScreenSizeProvider {
    override fun getScreenWidth(): Float {
        return UIScreen.mainScreen.bounds.useContents { size.width.toFloat() }
    }
}

actual fun getScreenSizeProvider(): ScreenSizeProvider {
    return IOSScreenSizeProvider()
}

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