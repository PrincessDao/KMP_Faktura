package org.example.kmp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Screens3() {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("", Modifier.padding(16.dp))

                Button(onClick = { navController.navigate("badges") }) {
                    Text("Значки")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { navController.navigate("buttons") }) {
                    Text("Кнопки")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { navController.navigate("chips") }) {
                    Text("Чипы")
                }
            }
        }
        composable("badges") { DesignBadges(navController) }
        composable("buttons") { DesignButtons(navController) }
        composable("chips") { DesignChips(navController) }
    }
}