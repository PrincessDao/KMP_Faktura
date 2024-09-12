package org.example.project
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import nastroiki.composeapp.generated.resources.Res
import nastroiki.composeapp.generated.resources.code
import nastroiki.composeapp.generated.resources.left
import nastroiki.composeapp.generated.resources.push
import nastroiki.composeapp.generated.resources.sbp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun App() {

    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {

        FrameOne()

        Spacer(modifier = Modifier.height(16.dp))


        FrameTwo(
            onItemClick = {
                coroutineScope.launch {
                    showSheet = true
                    sheetState.show()
                }
            }
        )
    }

    if (showSheet) {
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = {

                Box(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .align(Alignment.CenterHorizontally)
                        .size(width = 40.dp, height = 4.dp)
                        .background(Color.Black.copy(alpha = 0.5f))
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 13.dp)
                        ) {
                            val sbpIcon: Painter = painterResource(Res.drawable.sbp)
                            Image(
                                painter = sbpIcon,
                                contentDescription = null,
                                modifier = Modifier.size(48.dp)
                            )
                            Text(
                                modifier = Modifier.padding(vertical = 12.dp),
                                text = "Система быстрых платежейghghgh",
                                fontSize = 22.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = Bold,
                            )
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .padding(horizontal = 10.dp)
                        ) {
                            Text(
                                text = "Банк",
                                fontSize = 17.sp
                            )
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Счет",
                                fontSize = 17.sp
                            )
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Запросы",
                                fontSize = 17.sp
                            )
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "СБПэй",
                                fontSize = 17.sp
                            )
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Подписки",
                                fontSize = 17.sp
                            )
                        }
                    }
                }
            },
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetBackgroundColor = Color.White
        ) {
        }
    }
}

@Composable
@Preview
fun FrameOne() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val profileIcon: Painter = painterResource(Res.drawable.left)
            Image(
                painter = profileIcon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Профиль", fontSize = 15.sp)
        }
        Text(
            text = "Настройки",
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            fontWeight = Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 20.dp)
                ) {
                    val itemIcon: Painter = painterResource(Res.drawable.push)
                    Image(
                        painter = itemIcon,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = "Push-уведомления и sms",
                        fontSize = 17.sp
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 20.dp)
                )
                {
                    val itemIcon: Painter = painterResource(Res.drawable.code)
                    Image(
                        painter = itemIcon,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = "Вход по коду",
                        fontSize = 17.sp
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun FrameTwo(onItemClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = "Переводы",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontWeight = Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                        .padding(horizontal = 16.dp)
                        .clickable(onClick = onItemClick)
                ) {
                    val sbpIcon: Painter = painterResource(Res.drawable.sbp)
                    Image(
                        painter = sbpIcon,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = "Система быстрых платежей",
                        fontSize = 17.sp,
                    )
                }
            }
        }
    }
}
