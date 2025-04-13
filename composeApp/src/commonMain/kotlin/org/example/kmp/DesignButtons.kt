package org.example.kmp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DesignButtons(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Primary",
            fontSize = 22.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(horizontal = 20.dp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            enabled = true,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C85FF)),
            shape = RectangleShape,
            modifier = Modifier
                .size(width = 335.dp, height = 56.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Button",
                fontSize = 17.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0xFF4C85FF).copy(alpha = 0.5f)
            ),
            shape = RectangleShape,
            modifier = Modifier
                .size(width = 335.dp, height = 56.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Button",
                fontSize = 17.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Secondary",
            fontSize = 22.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(horizontal = 20.dp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            enabled = true,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6F9FF)),
            shape = RectangleShape,
            modifier = Modifier
                .size(width = 335.dp, height = 56.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Button",
                fontSize = 17.sp,
                color = Color(0xFF4C85FF),
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0xFFF6F9FF).copy(alpha = 0.5f)
            ),
            shape = RectangleShape,
            modifier = Modifier
                .size(width = 335.dp, height = 56.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Button",
                fontSize = 17.sp,
                color = Color(0xFF4C85FF).copy(alpha = 0.5f),
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tertiary",
            fontSize = 22.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(horizontal = 20.dp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            enabled = true,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
            shape = RectangleShape,
            modifier = Modifier
                .size(width = 335.dp, height = 56.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Button",
                fontSize = 17.sp,
                color = Color(0xFF4C85FF),
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0xFFFFFFFF).copy(alpha = 0.5f)
            ),
            shape = RectangleShape,
            modifier = Modifier
                .size(width = 335.dp, height = 56.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Button",
                fontSize = 17.sp,
                color = Color(0xFF4C85FF).copy(alpha = 0.5f),
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))


        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Назад")
        }
    }
}