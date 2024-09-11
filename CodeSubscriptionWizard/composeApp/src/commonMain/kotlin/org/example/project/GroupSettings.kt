package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codesubscriptionwizard.composeapp.generated.resources.Res
import codesubscriptionwizard.composeapp.generated.resources.arrow_left
import codesubscriptionwizard.composeapp.generated.resources.sbp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun GroupSettingsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
        ) {
            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(Res.drawable.arrow_left),
                    contentDescription = "Назад",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                        modifier = Modifier
                            .size(43.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = Color(0xffffffff))
                    ) {
                    Image(
                        painter = painterResource(Res.drawable.sbp),
                        contentDescription = "sbp",
                        modifier = Modifier
                            .size(25.dp)
                            .align(Alignment.Center)
                    )
                    }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Система быстрых\nплатежей",
                    style = TextStyle(
                        fontWeight = FontWeight.W500,
                        fontSize = 21.sp,
                        color = Color(0xffFFFFFF)
                    ),
                    modifier = Modifier
                        .padding(bottom = 3.dp),
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 4.dp),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 68.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Перевод в организацию",
                    style = TextStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp,
                        color = Color(0xffFFFFFF)
                    ),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        .background(Color.White)
                ) {
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}