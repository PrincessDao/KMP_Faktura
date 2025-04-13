package org.example.kmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.arrow_down
import kmp_faktura.composeapp.generated.resources.arrow_left
import kmp_faktura.composeapp.generated.resources.card
import kmp_faktura.composeapp.generated.resources.sbp
import kmp_faktura.composeapp.generated.resources.star
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SubscriptionShowingScreen(subscription: Triple<String, String, String>, navigationController: NavigationController) {
    var expanded by remember { mutableStateOf(false) }
    var isClicked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
        ) {
            IconButton(onClick = {
                if (!isClicked) {
                    isClicked = true
                    navigationController.popBackStack()
                }
            },
                ) {
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
                        .clip(RoundedCornerShape(14.dp))
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
                Column {
                    Text(
                        text = "Система быстрых платежей",
                        style = TextStyle(
                            fontWeight = FontWeight.W500,
                            fontSize = 21.sp,
                            color = Color(0xffFFFFFF),
                            fontFamily = SfProDisplayFontFamily()
                        ),
                    )
                    Text(
                        text = "Подписка",
                        style = TextStyle(
                            fontWeight = FontWeight.W400,
                            fontSize = 14.sp,
                            color = Color(0xffFFFFFF),
                            fontFamily = SfProDisplayFontFamily()
                        ),
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .fillMaxWidth(),
                    ) {
                        Column(
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(43.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(color = Color(0xffA56eff)),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(Res.drawable.star),
                                    contentDescription = "star",
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = subscription.first, style = TextStyle(
                                    fontWeight = FontWeight.W500,
                                    fontSize = 15.sp,
                                    color = Color(0xff3d4047),
                                    fontFamily = SfProDisplayFontFamily()
                                )
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = subscription.second, style = TextStyle(
                                    fontWeight = FontWeight.W400,
                                    fontSize = 13.sp,
                                    color = Color(0xff9397a1),
                                    fontFamily = SfProDisplayFontFamily()
                                )
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = subscription.third, style = TextStyle(
                                    fontWeight = FontWeight.W400,
                                    fontSize = 12.sp,
                                    color = Color(0xff9397a1),
                                    fontFamily = SfProDisplayFontFamily()
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp),
                        text = "Счет для оплаты",
                        style = TextStyle(
                            fontWeight = FontWeight.W700,
                            fontSize = 21.sp,
                            color = Color(0xff3D4047),
                            fontFamily = SfProDisplayFontFamily()
                        ),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth().background(color = Color(0xfff8f8f8))) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth().padding(start = 16.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.End,
                            ) {
                                Image(
                                    painter = painterResource(Res.drawable.card),
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp)
                                )
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(2.5.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xff9397a1))
                                    )
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Box(
                                        modifier = Modifier
                                            .size(2.5.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xff9397a1))
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))

                                    Text(
                                        text = "6689",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.W500,
                                        color = Color(0xff6d6e70),
                                        modifier = Modifier.align(Alignment.CenterVertically),
                                        fontFamily = SfProDisplayFontFamily()
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                }
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.weight(0.85f)
                            ) {
                                Text(text = "MasterCard Gold", fontWeight = FontWeight.W500, fontSize = 13.sp, color = Color(0xff6d6e70), fontFamily = SfProDisplayFontFamily())
                                Text(text = "40817810300000000004", fontSize = 13.sp, fontWeight = FontWeight.W500, color = Color(0xff9397a1), fontFamily = SfProDisplayFontFamily())
                                Text(text = "Доступно 1 234,56 ₽", fontSize = 13.sp, fontWeight = FontWeight.W500, color = Color(0xff9397a1), fontFamily = SfProDisplayFontFamily())
                            }

                            IconButton(onClick = { expanded = !expanded }) {
                                Icon(
                                    painter = painterResource(Res.drawable.arrow_down),
                                    modifier = Modifier
                                        .size(25.dp),
                                    contentDescription = null
                                )
                            }
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("") },
                                onClick = {}
                            )
                            DropdownMenuItem(
                                text = { Text("") },
                                onClick = {}
                            )
                            DropdownMenuItem(
                                text = { Text("") },
                                onClick = {}
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(85.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(color = Color(0xff4d85ff)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        )
                        {
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Отключить подписку",
                                style = TextStyle(
                                    fontWeight = FontWeight.W600,
                                    fontSize = 14.sp,
                                    color = Color(0xffffffff),
                                    fontFamily = SfProDisplayFontFamily()
                                ),
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
            }
        }
    }
}