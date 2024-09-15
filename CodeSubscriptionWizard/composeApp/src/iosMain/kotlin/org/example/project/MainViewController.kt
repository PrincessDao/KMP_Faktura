package org.example.project

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.*
import platform.CoreGraphics.CGRectMake
import kotlinx.cinterop.*

private val navigationController = UINavigationController()

fun MainViewController(): UIViewController {
    return ComposeUIViewController {
        SubscriptionScreens(navController = provideNavigationController())
    }
}

actual fun provideNavigationController(): NavigationController = IosNavigationController()

class IosNavigationController : NavigationController {
    override fun navigate(route: String) {
        val viewController = when (route) {
            "code_entry" -> ComposeUIViewController {
                CodeEntryScreen(navController = this)
            }.apply {
                setStatusBarColor(Color.White, true)
            }
            "subscription_list" -> ComposeUIViewController {
                SubscriptionListScreen(navController = this)
            }.apply {
                setStatusBarColor(Color(0xFF17093D), false)
            }
            else -> ComposeUIViewController {
            }
        }
        navigationController.pushViewController(viewController, animated = true)
    }

    override fun popBackStack() {
        navigationController.popViewControllerAnimated(true)
    }

    private fun UIViewController.setStatusBarColor(color: Color, isLightStatusBar: Boolean) {
        navigationController.navigationBar.barTintColor = UIColor(
            red = color.red.toDouble(),
            green = color.green.toDouble(),
            blue = color.blue.toDouble(),
            alpha = 1.0
        )

        val style = if (isLightStatusBar) {
            UIStatusBarStyleLightContent
        } else {
            UIStatusBarStyleDefault
        }
        navigationController.navigationBar.titleTextAttributes = nsDictionaryOf(
            NSForegroundColorAttributeName to (if (isLightStatusBar) UIColor.whiteColor else UIColor.blackColor)
        )
        navigationController.setNeedsStatusBarAppearanceUpdate()
    }

    override fun preferredStatusBarStyle(): UIStatusBarStyle {
        return navigationController.navigationBar.barTintColor?.let {
            if (it == UIColor.whiteColor) {
                UIStatusBarStyleDarkContent
            } else {
                UIStatusBarStyleLightContent
            }
        } ?: UIStatusBarStyleDefault
    }
}