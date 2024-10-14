package org.example.kmp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.arrow_left
import kmp_faktura.composeapp.generated.resources.arrow_left_dot
import kmp_faktura.composeapp.generated.resources.arrow_right_dot
import kmp_faktura.composeapp.generated.resources.arrow_right
import kmp_faktura.composeapp.generated.resources.arrow_down_big
import kmp_faktura.composeapp.generated.resources.arrow_up_big
import kmp_faktura.composeapp.generated.resources.arrow_up
import kmp_faktura.composeapp.generated.resources.arrow_down
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.jetbrains.compose.resources.painterResource

class NoRippleInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true

}

@Composable
fun DesignSystemScreen() {
    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFe5e5e5))
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    val previousScale = scale

                    scale *= zoom

                    val currentCenterX = offsetX + (size.width / 2) * previousScale
                    val currentCenterY = offsetY + (size.height / 2) * previousScale

                    val touchX = (currentCenterX + pan.x / previousScale)
                    val touchY = (currentCenterY + pan.y / previousScale)

                    offsetX = touchX - (size.width / 2) * scale
                    offsetY = touchY - (size.height / 2) * scale
                }
            }
    ) {
        Box(
            modifier = Modifier
                .layout { measurable, _ ->
                    val placeable = measurable.measure(constraints.copy(maxWidth = Int.MAX_VALUE, maxHeight = Int.MAX_VALUE))
                    layout(placeable.width, placeable.height) {
                        placeable.placeRelative(offsetX.toInt(), offsetY.toInt())
                    }
                }
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    translationX = offsetX,
                    translationY = offsetY
                )
        ) {
            Row {
                DotBannerSection(scale)
                Spacer(modifier = Modifier.width(70.dp))
                ActionSection(scale)
                Spacer(modifier = Modifier.width(180.dp))
                Box(modifier = Modifier.dashedBorderBox("Social Icons Section")) {
                    SocialIconsSection()
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFF2C2C2C), shape = RoundedCornerShape(10.dp))
                        .clip(RectangleShape)
                        .clickable(
                            onClick = { scale *= 1.1f },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "+")
                }
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFF2C2C2C), shape = RoundedCornerShape(10.dp))
                        .clip(RectangleShape)
                        .clickable(
                            onClick = { scale /= 1.1f },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "-")
                }
            }
        }
    }
}

@Composable
fun DotBannerSection(scale: Float) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextWithEllipsis(
            text = "row/dot banner",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
            DotBanner(totalDots = 10, currentIndex = 0)

        Spacer(modifier = Modifier.height(16.dp))
        TextWithEllipsis(
            text = "row/dot personal offer",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
            DotPersonalOffer(totalDots = 10)
    }
}

@Composable
fun DotBanner(totalDots: Int, currentIndex: Int) {
    Box(
        modifier = Modifier
            .size(375.dp, 21.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(totalDots) { index ->
                Box(
                    modifier = Modifier
                        .size(7.dp)
                        .background(
                            if (index == currentIndex) Color(0xFF4C85FF) else Color(0xFFEDF0F9),
                            shape = RoundedCornerShape(50)
                        )
                )
                if (index != totalDots - 1) Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun DotPersonalOffer(totalDots: Int) {
    var currentIndex by remember { mutableStateOf(0) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(375.dp, 53.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .size(375.dp, 21.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.Blue, shape = RectangleShape)
                        .clip(RectangleShape)
                        .clickable(
                            onClick = { if (currentIndex > 0) currentIndex-- },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_left_dot),
                        contentDescription = "Arrow Left",
                        tint = Color.Red,
                    )
                }
                Spacer(modifier = Modifier.width(63.5.dp))
                repeat(totalDots) { index ->
                    Box(
                        modifier = Modifier
                            .size(7.dp)
                            .background(
                                if (index == currentIndex) Color(0xFF4C85FF) else Color(0xFFEDF0F9),
                                shape = RoundedCornerShape(50)
                            )
                    )
                    if (index != totalDots - 1) Spacer(modifier = Modifier.width(10.dp))
                }
                Spacer(modifier = Modifier.width(63.5.dp))
                Button(
                    onClick = { if (currentIndex < totalDots - 1) currentIndex++ },
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.Transparent, shape = RectangleShape),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_right_dot),
                        contentDescription = "Arrow Right",
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}

@Composable
fun ActionSection(scale: Float) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextWithEllipsis(
            text = "action / down",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        ActionDown()

        Spacer(modifier = Modifier.height(16.dp))

        TextWithEllipsis(
            text = "action / up",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        ActionDown()

        Spacer(modifier = Modifier.height(16.dp))

        TextWithEllipsis(
            text = "action / roll up",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        ActionDown()

        Spacer(modifier = Modifier.height(16.dp))

        TextWithEllipsis(
            text = "action / slider",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        DotPersonalOffer(totalDots = 4)
    }
}

@Composable
fun ActionDown() {
    Box(
        modifier = Modifier
            .size(375.dp, 76.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.arrow_up_big),
                contentDescription = "Arrow Up",
                modifier = Modifier.size(24.dp),
                tint = Color(0xff3D4047)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Action",
                style = TextStyle(
                    fontWeight = FontWeight.W400,
                    fontSize = 17.sp,
                    lineHeight = 22.sp,
                    color = Color(0xff3D4047)
                ),
            )
        }
    }
}

@Composable
fun SocialIconsSection() {
    Column {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(6) {
                    CircleIcon()
                }
            }

        Spacer(modifier = Modifier.height(16.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(3) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        repeat(3) {
                            CircleIcon()
                        }
                    }
                }
            }
    }
}

@Composable
fun CircleIcon() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
            .background(color = Color.LightGray, shape = CircleShape)
    ) {
        Icon(
            contentDescription = "Placeholder Icon",
            painter = painterResource(Res.drawable.arrow_left),
            tint = Color.Transparent
        )
    }
}

@Composable
fun TextWithEllipsis(text: String, modifier: Modifier = Modifier, scale: Float) {
    val textStyle = TextStyle(fontSize = 10.sp / scale)

    Box(modifier = modifier.fillMaxWidth()) {
        Text(
            text = text,
            style = textStyle,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xff9d6bdb)
        )
    }
}

fun Modifier.dashedBorderBox(label: String): Modifier =
    this
        .padding(8.dp)
        .drawBehind {
            val paint = androidx.compose.ui.graphics.Paint().apply {
                color = Color(0xFF6200EE)
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            }
            drawRect(
                color = Color(0xFF6200EE),
                size = size,
                style = Stroke(
                    width = 1.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )
            )
        }
        .padding(16.dp)