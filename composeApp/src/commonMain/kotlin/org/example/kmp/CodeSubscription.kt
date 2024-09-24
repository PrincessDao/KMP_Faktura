package org.example.kmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CodeSubscription(/*platformController: PlatformController*/) {
    val navController = rememberNavController()
    val navigationController = NavigationControllerCross(navController)
    SubscriptionScreens(navController = navController, navigationController = navigationController/*, platformController = platformController*/)
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    setSurfaceColor: (Color) -> Unit,
    navigationController: NavigationController,
    /*platformController: PlatformController*/
) {
    NavHost(navController = navController, startDestination = "code_entry") {
        composable("code_entry") {
            setSurfaceColor(Color(0xffFFFFFFFF))
            //platformController.setStatusBarColor(0xffFFFFFFFF.toInt())
            CodeEntryScreen(navigationController)
        }
        composable("subscription_list") {
            setSurfaceColor(Color(0xffFF17093d))
            //platformController.setStatusBarColor(0xffFF17093d.toInt())
            SubscriptionListScreen(navigationController)
        }
        composable("subscription_showing/{first}/{second}/{third}") { backStackEntry ->
            setSurfaceColor(Color(0xffFF17093d))
            //platformController.setStatusBarColor(0xffFF17093d.toInt())
            val first = backStackEntry.arguments?.getString("first") ?: ""
            val second = backStackEntry.arguments?.getString("second") ?: ""
            val third = backStackEntry.arguments?.getString("third") ?: ""
            SubscriptionShowingScreen(
                subscription = Triple(first, second, third),
                navigationController = navigationController
            )
        }
    }
}
@Composable
fun SubscriptionScreens(navController: NavHostController, navigationController: NavigationController/*, platformController: PlatformController*/) {
    val (surfaceColor, setSurfaceColor) = remember { mutableStateOf(Color(0xffFF17093d)) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = surfaceColor
    ) {
        NavigationGraph(
            navController = navController,
            setSurfaceColor = setSurfaceColor,
            navigationController = navigationController,
            //platformController = platformController // Передаем сюда
        )
    }
}

class NavigationControllerCross(private val navController: NavHostController) : NavigationController {
    override fun navigate(route: String) {
        navController.navigate(route)
    }

    override fun popBackStack() {
        navController.popBackStack()
    }
}