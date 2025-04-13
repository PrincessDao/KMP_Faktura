package org.example.kmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun CodeSubscriptionAndDesignSystem(platformController: PlatformController) {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    when (selectedOption) {
        null -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = { selectedOption = "application" }) {
                    Text("Приложение", fontFamily = SfProTextFontFamily())
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { selectedOption = "design_system" }) {
                    Text("Дизайн-система", fontFamily = SfProTextFontFamily())
                }
            }
        }
        "application" -> {
            val navController = rememberNavController()
            val navigationController = NavigationControllerCross(navController)
            SubscriptionScreens(navController = navController, navigationController = navigationController, platformController = platformController)
        }
        "design_system" -> {
            DesignSystemScreen()
        }
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    setSurfaceColor: (Color) -> Unit,
    navigationController: NavigationController,
    platformController: PlatformController
) {
    NavHost(navController = navController, startDestination = "code_entry") {
        composable("code_entry") {
            setSurfaceColor(Color(0xffFFFFFFFF))
            platformController.setStatusBarColor(0xffFFFFFFFF.toInt())
            CodeEntryScreen(navigationController)
        }
        composable("subscription_list") {
            setSurfaceColor(Color(0xffFF17093d))
            platformController.setStatusBarColor(0xffFF17093d.toInt())
            SubscriptionListScreen(navigationController)
        }
        composable("subscription_showing/{first}/{second}/{third}") { backStackEntry ->
            setSurfaceColor(Color(0xffFF17093d))
            platformController.setStatusBarColor(0xffFF17093d.toInt())
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
fun SubscriptionScreens(navController: NavHostController, navigationController: NavigationController, platformController: PlatformController) {
    val (surfaceColor, setSurfaceColor) = remember { mutableStateOf(Color(0xffFF17093d)) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = surfaceColor
    ) {
        NavigationGraph(
            navController = navController,
            setSurfaceColor = setSurfaceColor,
            navigationController = navigationController,
            platformController = platformController
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