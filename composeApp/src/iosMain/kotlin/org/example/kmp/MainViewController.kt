package org.example.kmp

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIScreen

fun MainViewController() = ComposeUIViewController { App() }

class IosScreenSizeProvider: ScreenSizeProvider {
    override fun getScreenWidth(): Float {
        val screen = UIScreen.mainScreen
        return screen.bounds.size.width.toFloat()
    }
}