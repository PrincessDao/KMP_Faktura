package org.example.kmp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.code_one
import kmp_faktura.composeapp.generated.resources.code_two
import kmp_faktura.composeapp.generated.resources.code_three
import org.jetbrains.compose.resources.DrawableResource
import androidx.compose.material3.MaterialTheme

@Composable
@Preview
fun App(platformController: PlatformController) {
    var isDesignSystem by remember { mutableStateOf(false) }
    MaterialTheme {
        var currentScreen by remember { mutableStateOf("main") }

        platformController.setStatusBarColor(0xFF2C2C2C.toInt())

        Scaffold(
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color(0xFF2C2C2C),
                    contentColor = Color.Black
                ) {
                    val items = listOf(
                        BottomNavItem("Виталий", Res.drawable.code_one),
                        BottomNavItem("Яна", Res.drawable.code_two),
                        BottomNavItem("Иннокентий", Res.drawable.code_three)
                    )

                    items.forEachIndexed { index, item ->
                        BottomNavigationItem(
                            icon = { Icon(painterResource(item.iconRes), contentDescription = null) },
                            label = { Text(item.label, modifier = Modifier.padding(bottom = 12.dp), fontFamily = SfProTextFontFamily()) },
                            selected = currentScreen == getScreenForIndex(index),
                            onClick = {
                                currentScreen = getScreenForIndex(index)
                            },
                            selectedContentColor = Color.White,
                            unselectedContentColor = Color.Gray
                        )
                    }
                }
            }
        ) { innerPadding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (currentScreen) {
                    "DesignSystemAndCodeSubscription" -> {
                        platformController.setStatusBarColor(0xFF2C2C2C.toInt())
                        CodeSubscriptionAndDesignSystem(platformController)
                    }
                    "Экраны Яны" -> { //Поменяйте названия (как в getScreenForIndex)
                        platformController.setStatusBarColor(0xFF2C2C2C.toInt())
                        ProfileScreen() //Поменяйте названия
                    } //Поменяйте названия
                    "Экраны Иннокентия" -> { //Поменяйте названия (как в getScreenForIndex)
                       platformController.setStatusBarColor(0xFF2C2C2C.toInt())
                        Screens3() //Поменяйте названия
                    } //Поменяйте названия
                    else -> {
                        Text("Главный экран", Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

fun getScreenForIndex(index: Int): String {
    return when (index) {
        0 -> "DesignSystemAndCodeSubscription"
        1 -> "Экраны Яны" //Поменяйте названия
        2 -> "Экраны Иннокентия" //Поменяйте названия
        else -> "main"
    }
}

data class BottomNavItem(val label: String, val iconRes: DrawableResource)