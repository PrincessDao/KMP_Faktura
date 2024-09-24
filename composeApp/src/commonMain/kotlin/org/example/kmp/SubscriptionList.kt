package org.example.kmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.arrow_left
import kmp_faktura.composeapp.generated.resources.arrow_right
import kmp_faktura.composeapp.generated.resources.sbp
import kmp_faktura.composeapp.generated.resources.star
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

val subscriptions = listOf(
    Triple("ТСП для фактуры", "12345", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "235235", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "457475", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "124124214", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "4735", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "1235235", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "5688", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "125", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "689", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "08909890", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "12335", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "346", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "1747", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "858", "ООО \"ЛЕСОВИК\""),
    Triple("ТСП для фактуры", "112", "ООО \"ЛЕСОВИК\""),


)

@Composable
@Preview
fun SubscriptionListScreen(navigationController: NavigationController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
        ) {
            IconButton(onClick = { navigationController.popBackStack() }) {
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
                            color = Color(0xffFFFFFF)
                        ),
                    )
                    Text(
                        text = "Подписки",
                        style = TextStyle(
                            fontWeight = FontWeight.W400,
                            fontSize = 14.sp,
                            color = Color(0xffFFFFFF)
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
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 32.dp)
                ) {
                    items(subscriptions) { subscription ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .shadow(8.dp, RoundedCornerShape(8.dp), ambientColor = Color(0xff607C8E), spotColor = Color(0xff607C8E))
                                .background(Color.White)
                                .padding(16.dp)
                                .clickable {
                                    navigationController.navigate("subscription_showing/${subscription.first}/${subscription.second}/${subscription.third}")
                                },
                            verticalAlignment = Alignment.CenterVertically
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
                                Text(text = subscription.first, style = TextStyle(
                                    fontWeight = FontWeight.W500,
                                    fontSize = 15.sp,
                                    color = Color(0xff3d4047)
                                ))
                                Spacer(modifier = Modifier.height(3.dp))
                                Text(text = subscription.second, style = TextStyle(
                                    fontWeight = FontWeight.W400,
                                    fontSize = 13.sp,
                                    color = Color(0xff9397a1)
                                ))
                                Spacer(modifier = Modifier.height(3.dp))
                                Text(text = subscription.third, style = TextStyle(
                                    fontWeight = FontWeight.W400,
                                    fontSize = 12.sp,
                                    color = Color(0xff9397a1)
                                ))
                            }
                            Image(
                                painter = painterResource(Res.drawable.arrow_right),
                                contentDescription = "arrow_right",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}