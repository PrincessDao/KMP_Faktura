package org.example.kmp

import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarManager
import platform.UIKit.UIWindow
import platform.UIKit.UIViewController
import platform.UIKit.UIColor
import platform.darwin.NSObject

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

fun MainViewController() = ComposeUIViewController {
    val platformController = IOSPlatformController(UIApplication.sharedApplication.keyWindow)
    App(platformController)
}