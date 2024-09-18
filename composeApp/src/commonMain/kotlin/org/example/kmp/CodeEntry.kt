package org.example.project

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import kmp_faktura.composeapp.generated.resources.code_delete
import kmp_faktura.composeapp.generated.resources.code_eight
import kmp_faktura.composeapp.generated.resources.code_face_id
import kmp_faktura.composeapp.generated.resources.code_five
import kmp_faktura.composeapp.generated.resources.code_four
import kmp_faktura.composeapp.generated.resources.code_nine
import kmp_faktura.composeapp.generated.resources.code_one
import kmp_faktura.composeapp.generated.resources.code_seven
import kmp_faktura.composeapp.generated.resources.code_six
import kmp_faktura.composeapp.generated.resources.code_three
import kmp_faktura.composeapp.generated.resources.code_two
import kmp_faktura.composeapp.generated.resources.code_zero
import kmp_faktura.composeapp.generated.resources.icon_profile
import kmp_faktura.composeapp.generated.resources.logo_balance
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

val customRippleColor = Color(0xff4C85FF)

/*@Composable
@Preview
fun CodeEntryScreen(navController: NavigationController) {
    var inputCode by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter =  painterResource(Res.drawable.logo_balance),
                contentDescription = "logo balance",
                modifier = Modifier
                    .height(28.dp)
            )
        }
        Spacer(modifier = Modifier.weight(0.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(55.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(color = Color(0xffffffff))
            ) {
                Image(
                    painter = painterResource(Res.drawable.icon_profile),
                    contentDescription = "icon profile",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "Добрый день,",
                style = TextStyle(
                    fontFamily = sf_pro_display,
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp,
                    color = Color(0xff3D4047)
                ),
                modifier = Modifier
                    .padding(top = 10.dp),
            )
            Text(
                text = "Орхидея",
                style = TextStyle(
                    fontFamily = sf_pro_display,
                    fontWeight = FontWeight.W600,
                    fontSize = 17.sp,
                    color = Color(0xff3D4047)
                ),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                for (i in 0 until 4) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(if (i < inputCode.length) Color(0xff4C85FF) else Color(0xffe7eaed))
                    )
                    if (i < 3) Spacer(modifier = Modifier.width(12.dp))
                }
            }
            Spacer(modifier = Modifier.height(120.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val numberImages = mapOf(
                    "1" to Res.drawable.code_one,
                    "2" to Res.drawable.code_two,
                    "3" to Res.drawable.code_three,
                    "4" to Res.drawable.code_four,
                    "5" to Res.drawable.code_five,
                    "6" to Res.drawable.code_six,
                    "7" to Res.drawable.code_seven,
                    "8" to Res.drawable.code_eight,
                    "9" to Res.drawable.code_nine,
                    "face_id" to Res.drawable.code_face_id,
                    "0" to Res.drawable.code_zero,
                    "del" to Res.drawable.code_delete
                )

                val numbers = listOf(
                    listOf("1", "2", "3"),
                    listOf("4", "5", "6"),
                    listOf("7", "8", "9"),
                    listOf("face_id", "0", "del")
                )

                for (row in numbers) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        for ((index, item) in row.withIndex()) {
                            if (item.isNotEmpty()) {
                                IconButton(
                                    onClick = {
                                        if (item == "face_id") {
                                        } else if (item == "del") {
                                            if (inputCode.isNotEmpty()) {
                                                inputCode = inputCode.dropLast(1)
                                            }
                                        } else {
                                            if (inputCode.length < 4) {
                                                inputCode += item
                                            }
                                            if (inputCode.length == 4) {
                                                navController.navigate("subscription_list")
                                            }
                                        }
                                    },
                                    modifier = Modifier
                                        .size(60.dp)
                                ) {
                                    Image(
                                        painter = painterResource(numberImages[item] ?: Res.drawable.code_zero),
                                        contentDescription = null
                                    )
                                }

                                if (index < row.size - 1) {
                                    Spacer(modifier = Modifier.width(44.dp))
                                }
                            } else {
                                Spacer(modifier = Modifier.size(55.dp))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }

        }
        Spacer(modifier = Modifier.weight(0.08f))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Забыли?",
                style = TextStyle(
                    fontFamily = sf_pro_display,
                    fontWeight = FontWeight.W400,
                    fontSize = 17.sp,
                    color = Color(0xff4C85FF)
                ),
                modifier = Modifier.clickable {}
            )
        }
        Spacer(modifier = Modifier.weight(0.08f))
    }
}
*/