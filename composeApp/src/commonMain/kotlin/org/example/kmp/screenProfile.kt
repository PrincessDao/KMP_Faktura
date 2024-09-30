package org.example.kmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.addphoto
import kmp_faktura.composeapp.generated.resources.exit
import kmp_faktura.composeapp.generated.resources.info
import kmp_faktura.composeapp.generated.resources.notification
import kmp_faktura.composeapp.generated.resources.settings
import kmp_faktura.composeapp.generated.resources.strelka

@Composable
fun ProfileScreen() {  // Передаем контекст через параметры
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Установить фон всего экрана белым
    ) {
        TopAppBar(
            title = { Text("") }, // Пустой заголовок
            backgroundColor = Color.White,
            contentColor = Color.Black,
            elevation = 0.dp,
            navigationIcon = {
                IconButton(onClick = { /* Handle navigation icon press */ }) {
                    Icon(
                        painter = painterResource(Res.drawable.strelka),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* Handle bell icon press */ }) {
                    Icon(
                        painter = painterResource(Res.drawable.notification),
                        contentDescription = "Notifications",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        )

        Text(
            text = "Профиль",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp),
            color = Color(0xff3D4047)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Передаем defaultImage
        ProfileRow(
            name = "Ноябрьская Орхидея Июлевна",
            defaultImage = painterResource(Res.drawable.addphoto),
        )

        Spacer(modifier = Modifier.height(10.dp))

        SettingItem(painter = painterResource(Res.drawable.settings), text = "Настройки")
        SettingItem(painter = painterResource(Res.drawable.info), text = "О приложении")
        Spacer(modifier = Modifier.height(24.dp))
        SettingItem(painter = painterResource(Res.drawable.exit), text = "Выход")
    }
}



@Composable
fun ProfileRow(
    name: String,
    defaultImage: Painter,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .height(92.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF4C85FF)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(15.dp))

        Box(
            modifier = Modifier
                .size(64.dp, 61.33.dp)
                .clip(CircleShape)
                .background(Color(0xff5BA0FF))
                .clickable {
                    // Пока только кликабельно
                },
            contentAlignment = Alignment.Center
        ) {
            // Используем только дефолтное изображение
            ProfileImage(painter = defaultImage)
        }

        Spacer(modifier = Modifier.width(15.dp))

        Text(
            text = name,
            color = Color.White,
            fontSize = 17.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun ProfileImage(painter: Painter?) {
    if (painter != null) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(24.dp)
        )
    } else {
        Box(
            modifier = Modifier
                .size(64.dp) // Размер фона для видимости
                .background(Color.Gray) // Цвет фона для видимости
                .clip(CircleShape) // чтобы иконка была круглая
                .padding(8.dp) // Добавление отступа для центрирования иконки
        ) {
            Icon(
                painter = painterResource(Res.drawable.addphoto), // Используем сгенерированный ресурс
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp) // Размер иконки
                    .align(Alignment.Center) // Центрирование иконки внутри Box
            )
        }
    }
}


@Composable
fun SettingItem(painter: Painter, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Ширина заполняет доступное пространство
            .height(64.dp) // Высота 64.dp
            .clickable { /* Handle click */ }
            .padding(start = 20.dp, top = 16.dp, end = 20.dp, bottom = 16.dp), // Отступы
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painter, // Использование переданного Painter
            contentDescription = text,
            tint = Color(0xFF4C85FF), // Цвет иконки
            modifier = Modifier.size(32.dp) // Размер иконки
        )
        Spacer(modifier = Modifier.width(10.dp)) // Промежуток между иконкой и текстом
        Text(
            text = text,
            fontSize = 17.sp, // Размер шрифта 17sp
            fontWeight = FontWeight.Normal,
            color = Color(0xFF3D4047), // Цвет текста
            fontFamily = FontFamily.Default // Использование стандартного шрифта
        )
    }
}
