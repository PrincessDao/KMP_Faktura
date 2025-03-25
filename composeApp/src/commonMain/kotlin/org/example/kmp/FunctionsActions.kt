package org.example.kmp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.arrow_down_big
import kmp_faktura.composeapp.generated.resources.arrow_left_dot
import kmp_faktura.composeapp.generated.resources.arrow_right_dot
import kmp_faktura.composeapp.generated.resources.arrow_up
import kmp_faktura.composeapp.generated.resources.arrow_up_big
import org.jetbrains.compose.resources.painterResource



    @Composable
    fun DotBanner(
        totalDots: Int = DefaultTotalDots.current,
        currentIndex: Int = DefaultCurrentIndex.current,
        unselectedColor: Color = DefaultUnselectedColor.current,
        selectedColor: Color = DefaultSelectedColor.current
    ): Int {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            repeat(totalDots) { index ->
                Box(
                    modifier = Modifier
                        .size(7.dp)
                        .background(
                            if (index == currentIndex) selectedColor else unselectedColor,
                            shape = RoundedCornerShape(50)
                        )
                )
                if (index != totalDots - 1) Spacer(modifier = Modifier.width(10.dp))
            }
        }
        return currentIndex
    }

    @Composable
    fun DotPersonalOffer(
        totalDots: Int = DefaultTotalDots.current,
        unselectedColor: Color = DefaultUnselectedColor.current,
        selectedColor: Color = DefaultSelectedColor.current
    ): Int {
        var currentIndex by remember { mutableStateOf(0) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Transparent, shape = RectangleShape)
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
                    tint = if (currentIndex > 0) selectedColor else unselectedColor,
                )
            }
            Spacer(modifier = Modifier.width(63.5.dp))
            repeat(totalDots) { index ->
                Box(
                    modifier = Modifier
                        .size(7.dp)
                        .background(
                            if (index == currentIndex) selectedColor else unselectedColor,
                            shape = RoundedCornerShape(50)
                        )
                )
                if (index != totalDots - 1) Spacer(modifier = Modifier.width(10.dp))
            }
            Spacer(modifier = Modifier.width(63.5.dp))
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Transparent, shape = RectangleShape)
                    .clickable(
                        onClick = { if (currentIndex < totalDots - 1) currentIndex++ },
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.arrow_right_dot),
                    contentDescription = "Arrow Right",
                    tint = if (currentIndex < totalDots - 1) selectedColor else unselectedColor,
                )
            }
        }
        return currentIndex
    }

    @Composable
    fun ActionDown(
        onClick: () -> Unit = DefaultOnClick.current,
        foreColor: Color = DefaultForeColor.current,
        text: String = DefaultActionText.current
    ) {
        Box(
            modifier = Modifier
                .size(343.dp, 46.dp)
                .clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
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
                    tint = foreColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = text,
                    style = TextStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 17.sp,
                        lineHeight = 22.sp,
                        color = foreColor,
                        fontFamily = SfProTextFontFamily()
                    ),
                )
            }
        }
    }

    @Composable
    fun ActionUp(
        onClick: () -> Unit = DefaultOnClick.current,
        foreColor: Color = DefaultForeColor.current,
        text: String = DefaultActionText.current
    ) {
        Box(
            modifier = Modifier
                .size(343.dp, 46.dp)
                .clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.arrow_down_big),
                    contentDescription = "Arrow Down",
                    modifier = Modifier.size(24.dp),
                    tint = foreColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = text,
                    style = TextStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 17.sp,
                        lineHeight = 22.sp,
                        color = foreColor,
                        fontFamily = SfProTextFontFamily()
                    ),
                )
            }
        }
    }

    @Composable
    fun ActionRollUp(
        onClick: () -> Unit = DefaultOnClick.current,
        backgroundColor: Color = DefaultBackgroundRollColor.current,
        textColor: Color = DefaultActionTextColor.current,
        arrowColor: Color = DefaultArrowColor.current
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(114.dp, 32.dp)
                    .background(backgroundColor, shape = RoundedCornerShape(34.dp))
                    .clickable(
                        onClick = onClick,
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Свернуть",
                        style = TextStyle(
                            fontWeight = FontWeight.W400,
                            fontSize = 15.sp,
                            lineHeight = 20.sp,
                            color = textColor,
                            fontFamily = SfProTextFontFamily()
                        ),
                    )
                    Icon(
                        painter = painterResource(Res.drawable.arrow_up),
                        contentDescription = "Arrow Up",
                        tint = arrowColor,
                    )
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
        }
    }

    @Composable
    fun ActionSlider(
        totalDots: Int = DefaultSliderTotalDots.current,
        unselectedColor: Color = DefaultUnselectedColor.current,
        selectedColor: Color = DefaultSelectedColor.current
    ): Int {
        var currentIndex by remember { mutableStateOf(0) }
        var offsetX by remember { mutableStateOf(0f) }
        val density = LocalDensity.current
        val dotSpacing = with(density) { 26.dp.toPx() }

        Row(
            modifier = Modifier
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX -= dragAmount
                        val newIndex = (offsetX / dotSpacing).toInt().coerceIn(0, totalDots - 1)
                        if (newIndex != currentIndex) {
                            currentIndex = newIndex
                        }
                    }
                }
        ) {
            repeat(totalDots) { index ->
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(
                            if (index == currentIndex) selectedColor else unselectedColor,
                            shape = RoundedCornerShape(50)
                        )
                )
                if (index != totalDots - 1) Spacer(modifier = Modifier.width(10.dp))
            }
        }
        return currentIndex
    }

    @Composable
    fun ActionRow(
        onClick: () -> Unit = DefaultOnClick.current,
        text: String = DefaultRowText.current,
        textColor: Color = DefaultRowTextColor.current,
        iconPainter: Painter,
        iconColor: Color = DefaultRowIconColor.current,
        circleColor: Color = DefaultRowCircleColor.current,
        circleVisibility: Float = DefaultRowCircleVisibility.current,
    ) {
        Box(
            modifier = Modifier
                .size(76.dp, 114.dp)
                .clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = circleColor.copy(alpha = circleVisibility),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        contentDescription = "Action Icon",
                        painter = iconPainter,
                        tint = iconColor,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = text,
                    style = TextStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        color = textColor,
                        fontFamily = SfProTextFontFamily()
                    ),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }

    @Composable
    fun SocialRow(
        onClick: () -> Unit = DefaultOnClick.current,
        iconPainter: Painter,
        iconColor: Color = DefaultSocialRowIconColor.current,
        circleColor: Color = DefaultSocialRowCircleColor.current
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp)
                .background(color = circleColor, shape = CircleShape)
                .clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ),
        ) {
            Icon(
                contentDescription = "Action Social Icon",
                painter = iconPainter,
                tint = iconColor,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }