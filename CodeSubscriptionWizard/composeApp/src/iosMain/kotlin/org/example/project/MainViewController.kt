package org.example.project

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.*
import platform.CoreGraphics.CGRectMake
import kotlinx.cinterop.*
import platform.UIKit.UINavigationController

private val navigationController = UINavigationController()

class IosNavigationController : NavigationController {
    override fun navigate(route: String) {
        val viewController = when (route) {
            "code_entry" -> ComposeUIViewController {
                CodeEntryScreen(navController = this)
            }
            "subscription_list" -> ComposeUIViewController {
                SubscriptionListScreen(navController = this)
            }
            else -> UIViewController()
        }
        navigationController.pushViewController(viewController, animated = true)
    }

    override fun popBackStack() {
        navigationController.popViewControllerAnimated(true)
    }
}