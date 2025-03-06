package org.example.kmp

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.platform.ViewConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.minus
import kmp_faktura.composeapp.generated.resources.pages
import kmp_faktura.composeapp.generated.resources.plus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.jetbrains.compose.resources.painterResource

class CustomViewConfiguration(
    private val original: ViewConfiguration,
    private val customMinimumTouchTargetSize: DpSize
) : ViewConfiguration {
    override val longPressTimeoutMillis: Long
        get() = original.longPressTimeoutMillis
    override val doubleTapTimeoutMillis: Long
        get() = original.doubleTapTimeoutMillis
    override val doubleTapMinTimeMillis: Long
        get() = original.doubleTapMinTimeMillis
    override val touchSlop: Float
        get() = original.touchSlop
    override val minimumTouchTargetSize: DpSize
        get() = customMinimumTouchTargetSize
    override val maximumFlingVelocity: Float
        get() = original.maximumFlingVelocity
}

@Composable
fun ProvideCustomViewConfiguration(
    minTouchTargetSize: Dp = 24.dp,
    content: @Composable () -> Unit
) {
    val customConfig = CustomViewConfiguration(
        original = LocalViewConfiguration.current,
        customMinimumTouchTargetSize = DpSize(minTouchTargetSize, minTouchTargetSize)
    )
    CompositionLocalProvider(LocalViewConfiguration provides customConfig) {
        content()
    }
}

expect fun getScreenSizeProvider(): ScreenSizeProvider

@Composable
fun DesignSystemScreen() {
    ProvideCustomViewConfiguration(minTouchTargetSize = 24.dp) {
        var scale by remember { mutableStateOf(1f) }
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        var isExpanded by remember { mutableStateOf(false) }
        val transitionState = remember { MutableTransitionState(isExpanded) }
        var pages by remember { mutableStateOf(1) }
        transitionState.targetState = isExpanded

        val offset by animateFloatAsState(
            targetValue = if (isExpanded) 0f else -1f,
            animationSpec = tween(durationMillis = 300)
        )

        val screenWidth = getScreenSizeProvider().getScreenWidth().toInt()

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
                        val placeable = measurable.measure(
                            constraints.copy(
                                maxWidth = Int.MAX_VALUE,
                                maxHeight = Int.MAX_VALUE
                            )
                        )
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
                    when (pages) {
                        1 -> {
                            DotBannerSection(scale)
                            Spacer(modifier = Modifier.width(70.dp))
                            ActionSection(scale)
                            Spacer(modifier = Modifier.width(180.dp))
                            ActionsRowSection(scale)
                            Spacer(modifier = Modifier.width(88.dp))
                            SocialRowSection(scale)
                        }
                        2 -> {

                        }
                        3 -> {
                            PaddingSection(scale)
                        }
                        4 -> {
                            SlidesSection(scale)
                            SelectorsButtonsSection(scale)
                            Spacer(modifier = Modifier.width(87.dp))
                            ActionsSelectorSection(scale)
                        }
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
                        Icon(
                            contentDescription = "Button distance plus",
                            painter = painterResource(Res.drawable.plus),
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
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
                        Icon(
                            contentDescription = "Button distance minus",
                            painter = painterResource(Res.drawable.minus),
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color(0xFF2C2C2C), shape = RoundedCornerShape(10.dp))
                            .clip(RectangleShape)
                            .clickable(
                                onClick = { isExpanded = !isExpanded },
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            contentDescription = "Pages Lists",
                            painter = painterResource(Res.drawable.pages),
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, end = 72.dp, top = 16.dp, bottom = 16.dp)
                    .offset(x = with(LocalDensity.current) { (offset * screenWidth).dp}),

                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .background(Color(0xFF2C2C2C), shape = RoundedCornerShape(10.dp))
                        .height(48.dp)
                        .width(screenWidth.dp)
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    SystemRadioButton(
                        label = "Actions",
                        isSelected = pages == 1,
                        onClick = { pages = 1 }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    SystemRadioButton(
                        label = "Input",
                        isSelected = pages == 2,
                        onClick = { pages = 2 }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    SystemRadioButton(
                        label = "Padding",
                        isSelected = pages == 3,
                        onClick = { pages = 3 }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    SystemRadioButton(
                        label = "Selectors",
                        isSelected = pages == 4,
                        onClick = { pages = 4 }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}

@Composable
fun SystemRadioButton(label: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(
                color = if (isSelected) Color(0xFF383838) else Color(0xFF2C2C2C),
                shape = RoundedCornerShape(34.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = TextStyle(
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    color = if (isSelected) Color.White else Color.Gray,
                    fontFamily = SfProTextFontFamily()
                )
            )
        }
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
            color = Color(0xff9d6bdb),
            fontFamily = SfProTextFontFamily()
        )
    }
}

fun Modifier.dashedBorderBox(cornerRadius: Dp = 10.dp): Modifier =
    this
        .drawBehind {
            val cornerRadiusPx = cornerRadius.toPx()
            val paint = androidx.compose.ui.graphics.Paint().apply {
                color = Color(0xFF7b61ff)
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 15f), 0f)
            }

            val path = Path().apply {
                addRoundRect(
                    roundRect = RoundRect(
                        rect = Rect(0f, 0f, size.width, size.height),
                        cornerRadius = CornerRadius(cornerRadiusPx, cornerRadiusPx)
                    )
                )
            }

            drawPath(
                path = path,
                color = Color(0xFF7b61ff),
                style = Stroke(
                    width = 0.9.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 15f), 0f)
                )
            )
        }
        .padding(20.dp)