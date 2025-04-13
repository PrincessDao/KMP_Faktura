package org.example.kmp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.arrow_up
import org.jetbrains.compose.resources.painterResource

@Composable
fun DesignChips(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(32.dp))
        Row {
            ElevatedAssistChip(
                onClick = { /* Do something! */ },
                label = {
                    androidx.compose.material.Text(
                        "Название",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_up),
                        contentDescription = null,
                        modifier = Modifier
                            .size(19.dp)
                    )
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .size(width = 115.dp, height = 32.dp),
                colors = AssistChipDefaults.elevatedAssistChipColors(
                    containerColor = Color(0xFF4C85FF),
                    labelColor = Color.White
                ),
            )

            Spacer(modifier = Modifier.width(16.dp))

            ElevatedAssistChip(
                onClick = { /* Do something! */ },
                label = {
                    androidx.compose.material.Text(
                        "Название",
                        fontSize = 14.sp,
                        color = Color(0xFF555963)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_up),
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp)
                            .padding(end = 16.dp)
                    )
                },
                enabled = false,
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .size(width = 115.dp, height = 32.dp),
                colors = AssistChipDefaults.elevatedAssistChipColors(
                    disabledContainerColor = Color(0xFFF6F9FF),
                    disabledLabelColor = Color(0xFF555963),
                    labelColor = Color(0xFF555963)
                ),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            var selected by remember { mutableStateOf(false) }
            ElevatedFilterChip(
                selected = selected,
                onClick = { selected = !selected },
                label = {
                    androidx.compose.material.Text(
                        "Chips",
                        style = TextStyle(color = if (selected) Color.White else Color.Black)
                    )
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .size(width = 67.dp, height = 32.dp),
                colors = FilterChipDefaults.elevatedFilterChipColors(
                    disabledContainerColor = Color.White,
                    selectedContainerColor = Color(0xFF4C85FF),
                    selectedLabelColor = Color.White,
                    disabledLabelColor = Color.Black,
                    labelColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.width(16.dp))

            var selected1 by remember { mutableStateOf(false) }
            ElevatedFilterChip(
                selected = selected1,
                onClick = { selected1 = !selected1 },
                label = {
                    androidx.compose.material.Text(
                        "Chips",
                        style = TextStyle(color = if (selected1) Color.White else Color.Black)
                    )
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .size(width = 67.dp, height = 32.dp),
                colors = FilterChipDefaults.elevatedFilterChipColors(
                    disabledContainerColor = Color.White,
                    selectedContainerColor = Color(0xFF4C85FF),
                    selectedLabelColor = Color.White,
                    disabledLabelColor = Color.Black,
                    labelColor = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Назад")
        }
    }
}