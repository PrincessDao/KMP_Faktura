package org.example.project

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cft_settings.android.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("InvalidColorHexValue")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffFF17093d)
                ) {
                    val navController = rememberNavController()
                    SubscriptionScreens(navController = navController)
                }
            }
        }
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, setSurfaceColor: (Color) -> Unit) {
    NavHost(navController = navController, startDestination = "code_entry") {
        composable("code_entry") {
            setSurfaceColor(Color(0xffFFFFFFFF))
            CodeEntryScreen(AndroidNavigationController(navController))
        }
        composable("subscription_list") {
            setSurfaceColor(Color(0xffFF17093d))
            SubscriptionListScreen(AndroidNavigationController(navController))
        }
        composable("subscription_showing/{first}/{second}/{third}") { backStackEntry ->
            setSurfaceColor(Color(0xffFF17093d))
            val first = backStackEntry.arguments?.getString("first") ?: ""
            val second = backStackEntry.arguments?.getString("second") ?: ""
            val third = backStackEntry.arguments?.getString("third") ?: ""
            SubscriptionShowingScreen(
                subscription = Triple(first, second, third),
                navController = AndroidNavigationController(navController)
            )
        }
    }
}

class AndroidNavigationController(private val navController: NavHostController) : NavigationController {
    override fun navigate(route: String) {
        navController.navigate(route)
    }
    override fun popBackStack() {
        navController.popBackStack()
    }
}

@Composable
fun SubscriptionScreens(navController: NavHostController) {
    val (surfaceColor, setSurfaceColor) = remember { mutableStateOf(Color(0xffFF17093d)) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = surfaceColor
    ) {
        NavigationGraph(navController = navController, setSurfaceColor = setSurfaceColor)

        val currentBackStackEntry = navController.currentBackStackEntryAsState().value
        when (currentBackStackEntry?.destination?.route) {
            "code_entry" -> {
                ChangeStatusBarColor(color = Color(0xffFFFFFF), isLightStatusBar = true)
            }
            "subscription_list" -> {
                ChangeStatusBarColor(color = Color(0xff17093d), isLightStatusBar = false)
            }
        }
    }
}

@Composable
fun ChangeStatusBarColor(color: Color, isLightStatusBar: Boolean) {
    val view = LocalView.current
    val activity = LocalContext.current as ComponentActivity

    SideEffect {
        activity.window.statusBarColor = color.toArgb()
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars = isLightStatusBar
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val navController = rememberNavController()
    SubscriptionScreens(navController)
}