package org.example.scrprofile

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Shader
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squareup.picasso.Transformation
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.applyCanvas
import androidx.core.graphics.createBitmap



@Composable
fun ProfileScreen() {
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
                        painter = painterResource("composeResources/drawable/strelka.png"),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* Handle bell icon press */ }) {
                    Icon(
                        painter = painterResource("composeResources/drawable/notification.png"),
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

        ProfileRow(name = "Ноябрьская Орхидея Июлевна") // переменная для имени ProfileRow

        Spacer(modifier = Modifier.height(10.dp))

        // Используем измененную версию SettingItem с painter
        SettingItem(painter = painterResource("composeResources/drawable/settings.png"), text = "Настройки")
        SettingItem(painter = painterResource("composeResources/drawable/info.png"), text = "О приложении")
        Spacer(modifier = Modifier.height(24.dp))
        SettingItem(painter = painterResource("composeResources/drawable/exit.png"), text = "Выход")
    }
}

// Изменение SettingItem для использования painter
@Composable
fun SettingItem(painter: Painter, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painter,
            contentDescription = text,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}


@Composable
fun ProfileRow(name: String) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // Лончер для выбора изображения из галереи
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp) // Отступы по 15dp слева и справа
            .height(92.dp) // Высота 92dp
            .clip(RoundedCornerShape(16.dp)) // Закругленные углы
            .background(Color(0xFF4C85FF)), // Фон
        verticalAlignment = Alignment.CenterVertically // Центрирование элементов по вертикали
    ) {
        Spacer(modifier = Modifier.width(15.dp)) // пространство между прямоугольником и кругом

        // Круг с загруженным изображением или иконкой внутри
        Box(
            modifier = Modifier
                .size(64.dp, 61.33.dp) // Размеры круга
                .clip(CircleShape) // Форма круга
                .background(Color(0xff5BA0FF)) // Цвет фона круга
                .clickable {
                    launcher.launch("image/*") // Запуск выбора изображения
                },
            contentAlignment = Alignment.Center
        ) {
            ProfileImage(imageUri = imageUri) // Используем новую функцию ProfileImage
        }

        Spacer(modifier = Modifier.width(15.dp)) // Отступ между кругом и текстом

        Text(
            text = name, // Используем переменную для текста
            color = Color.White,
            fontSize = 17.sp,
            modifier = Modifier.align(Alignment.CenterVertically) // Центрирование текста по вертикали
        )
    }
}

@Composable
fun ProfileImage(imageUri: Uri?) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize() // Заполняет всю доступную область
    ) {
        if (imageUri != null) {
            val bitmap = remember(imageUri) {
                loadBitmapFromUri(context, imageUri)
            }

            val circleBitmap = remember(bitmap) {
                bitmap?.let { cropCircleBitmap(it) }
            }

            circleBitmap?.let {
                Image(
                    painter = BitmapPainter(it.asImageBitmap()),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        } else {
            Icon(
                painter = painterResource("composeResources/drawable/addphoto.png"),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp) // Размер иконки
                    .align(Alignment.Center) // Центрирование иконки внутри Box
            )
        }
    }
}


fun loadBitmapFromUri(context: Context, uri: Uri): Bitmap? {
    return context.contentResolver.openInputStream(uri)?.use { inputStream ->
        BitmapFactory.decodeStream(inputStream)
    }
}

fun cropCircleBitmap(bitmap: Bitmap): Bitmap {
    val size = minOf(bitmap.width, bitmap.height)
    val output = createBitmap(size, size, Bitmap.Config.ARGB_8888)
    val paint = Paint().apply {
        isAntiAlias = true
        shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }

    output.applyCanvas {
        drawCircle(size / 2f, size / 2f, size / 2f, paint)
    }

    return output
}


@Composable
fun SettingItem(iconId: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Ширина заполнит доступное пространство
            .height(64.dp) // Высота 64.dp
            .clickable { /* Handle click */ }
            .padding(start = 20.dp, top = 16.dp, end = 20.dp, bottom = 16.dp), // Отступы
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconId), // Иконка
            contentDescription = text,
            tint = Color(0xFF4C85FF), // Цвет иконки
            modifier = Modifier.size(24.dp) // Размер иконки
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

class CircleCropTransformation : Transformation {
    override fun key(): String = "circleCrop"

    override fun transform(source: Bitmap): Bitmap {
        val size = source.width.coerceAtMost(source.height)
        val x = (source.width - size) / 2
        val y = (source.height - size) / 2

        val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
        if (squaredBitmap != source) {
            source.recycle()
        }

        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)

        val canvas = Canvas(bitmap)
        val paint = Paint().apply {
            isAntiAlias = true
            shader = BitmapShader(squaredBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        }

        val r = size / 2f
        canvas.drawCircle(r, r, r, paint)

        squaredBitmap.recycle()
        return bitmap
    }
}