package org.example.kmp

import androidx.compose.ui.window.ComposeUIViewController
import UIKit
import Foundation
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow
import platform.UIKit.UIView
import platform.UIKit.UIColor
import platform.UIKit.UIViewController

fun MainViewController() = ComposeUIViewController {
    App(PlatformControllerIOS())
}

@objc class PlatformControllerIOS: NSObject, PlatformController {
    func setStatusBarColor(color: Int32) {
        let uiColor = UIColor(
                red: CGFloat((color >> 16) & 0xFF) / 255.0,
        green: CGFloat((color >> 8) & 0xFF) / 255.0,
        blue: CGFloat(color & 0xFF) / 255.0,
        alpha: 1.0
        )

        if let window = UIApplication.shared.windows.first {
            let statusBarFrame = window.windowScene?.statusBarManager?.statusBarFrame ?? CGRect.zero
            let statusBarView = UIView(frame: statusBarFrame)
            statusBarView.backgroundColor = uiColor
            window.addSubview(statusBarView)
        }
    }
}