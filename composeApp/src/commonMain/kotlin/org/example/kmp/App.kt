package org.example.kmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var currentScreen by remember { mutableStateOf("main") }

        when (currentScreen) {
            "main" -> {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = {
                                currentScreen = "codeSubscription"
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Виталий")
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Яна")
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Иннокентий")
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            "codeSubscription" -> {
                CodeSubscription()
            }
        }
    }
}