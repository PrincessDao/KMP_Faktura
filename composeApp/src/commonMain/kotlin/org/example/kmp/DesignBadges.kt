package org.example.kmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.airplane
import org.jetbrains.compose.resources.painterResource

@Composable
fun DesignBadges(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Первый бейдж с суммой
        Badge(
            modifier = Modifier
                .size(width = 79.dp, height = 36.dp),
            containerColor = Color(0xFF4C85FF),
            contentColor = Color.White,
            content = {
                Text(
                    "1 567 \u20BD",
                    color = Color.White
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Ряд круглых бейджей
        Row {
            Badge(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .size(width = 6.dp, height = 6.dp),
                containerColor = Color(0xFFFAB958),
            )

            Badge(
                modifier = Modifier
                    .padding(start = 6.dp, top = 5.dp)
                    .size(width = 24.dp, height = 24.dp),
                containerColor = Color(0xFFF87777),
                content = {
                    Text("1", color = Color.White)
                }
            )

            Badge(
                modifier = Modifier
                    .padding(start = 6.dp)
                    .size(width = 32.dp, height = 32.dp),
                containerColor = Color(0xFF3D4047),
                content = {
                    Text("4", color = Color.White)
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Ряд BadgedBox с иконками (исправленная версия)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            // Первый BadgedBox
            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .height(32.dp)
                    .background(Color(0xFF4C85FF), RoundedCornerShape(16.dp))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Text(
                        "11",
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 4.dp)
                            .padding(top = 4.dp)
                    )
                    Icon(
                        painter = painterResource(Res.drawable.airplane),
                        contentDescription = "airplane",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(top = 4.dp)
                    )
                }
            }

            // Второй BadgedBox
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .background(Color(0xFF555963).copy(alpha = 0.2f), RoundedCornerShape(16.dp))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Text(
                        "11",
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .padding(top = 4.dp)
                    )
                    Icon(
                        painter = painterResource(Res.drawable.airplane),
                        contentDescription = "airplane",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(top = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(55.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Назад")
        }
    }
}