package org.example.kmp

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
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
import kmp_faktura.composeapp.generated.resources.check
import org.jetbrains.compose.resources.painterResource

@Composable
fun Slider(
    onOccupancyChange: (Float) -> Unit = DefaultOnOccupancyChange.current,
    occupancy: Float = DefaultOccupancy.current,
    fillerColor: Color = DefaultFillerColor.current,
    blankColor: Color = DefaultBlankColor.current,
) {
    val density = LocalDensity.current
    val currentOccupancy = remember { mutableStateOf(occupancy) }
    val width = remember { mutableStateOf(0f) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .onGloballyPositioned { coordinates ->
                    width.value = coordinates.size.width.toFloat()
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(blankColor, shape = RoundedCornerShape(50))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(currentOccupancy.value)
                    .height(2.dp)
                    .background(fillerColor, shape = RoundedCornerShape(50))
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .offset(
                    x = with(density) { (currentOccupancy.value * width.value).toDp() } - 12.dp
                )
                .size(24.dp)
                .background(Color.White, shape = CircleShape)
                .border(7.dp, fillerColor, shape = CircleShape)
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { _, dragAmount ->
                        val newOccupancy = ((currentOccupancy.value * width.value + dragAmount).coerceIn(0f, width.value) / width.value)
                        currentOccupancy.value = newOccupancy
                        onOccupancyChange(newOccupancy)
                    }
                }
        )
    }
}


@Composable
fun LimitSlider(
    onOccupancyChange: (Float) -> Unit = DefaultOnOccupancyChange.current,
    occupancy: Float = DefaultOccupancy.current,
    fillerColor: Color = DefaultFillerColor.current,
    blankColor: Color = DefaultBlankColor.current,
) {
    val currentOccupancy = remember { mutableStateOf(occupancy) }
    val width = remember { mutableStateOf(0f) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .onGloballyPositioned { coordinates ->
                    width.value = coordinates.size.width.toFloat()
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(blankColor, shape = RoundedCornerShape(50))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(currentOccupancy.value)
                    .height(3.dp)
                    .background(fillerColor, shape = RoundedCornerShape(50))
            )
        }
    }
}

@Composable
fun RadioButton(
    enabled: Boolean = DefaultEnabled.current,
    enabledColor: Color = DefaultEnabledColor.current,
) {
    var currentState by remember { mutableStateOf(enabled) }
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(Color.Transparent, shape = CircleShape)
            .border(
                if (currentState) 7.dp else 1.dp,
                if (currentState) enabledColor else Color(0xffbdbdbf),
                shape = CircleShape
            )
            .clickable(
                onClick = { currentState = !currentState },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
    )
}

@Composable
fun CheckBox(
    enabled: Boolean = DefaultEnabled.current,
    enabledColor: Color = DefaultEnabledColor.current,
) {
    var currentState by remember { mutableStateOf(enabled) }
    Box(
        modifier = Modifier
            .size(24.dp)
            .border(
                if (currentState) 0.dp else 1.dp,
                if (currentState) enabledColor else Color(0xffbdbdbf),
                shape = RoundedCornerShape(15)
            )
            .clickable(
                onClick = { currentState = !currentState },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        contentAlignment = Alignment.Center
    ) {
        if (currentState)
        Icon(
            contentDescription = "Check Icon",
            painter = painterResource(Res.drawable.check),
            tint = enabledColor
        )
    }
}

@Composable
fun Switch(
    enabled: Boolean = DefaultEnabled.current,
    enabledColor: Color = DefaultEnabledColor.current,
) {
    var currentState by remember { mutableStateOf(enabled) }
    val transition = updateTransition(targetState = currentState, label = "switchTransition")
    val offset by transition.animateDp(
        transitionSpec = { spring(stiffness = Spring.StiffnessMedium) },
        label = "switchOffset"
    ) { state ->
        if (state) 21.dp else 2.dp
    }

    Box(
        modifier = Modifier
            .size(51.dp, 31.dp)
            .background(
                if (currentState) enabledColor else Color(0xFFE7EAED),
                shape = CircleShape
            )
            .clickable(
                onClick = { currentState = !currentState },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = offset)
                .size(28.dp)
                .shadow(28.dp, RoundedCornerShape(50.dp), spotColor = Color(0xff000000).copy(alpha = 0.5f))
                .border(
                    0.5.dp,
                    Color(0xffE7EAED),
                    shape = CircleShape
                )
                .background(Color.White, shape = CircleShape)
        )
    }
}

@Composable
fun ValueSmall(
    enabled: Boolean = DefaultEnabled.current,
    enabledColor: Color = DefaultEnabledColor.current,
    iconPainter: Painter,
) {
    var currentState by remember { mutableStateOf(enabled) }
    Box(
        modifier = Modifier
            .size(40.dp)
            .then(if (!currentState) Modifier.shadow(40.dp, RoundedCornerShape(50.dp), ambientColor = Color(0xff607C8E), spotColor = Color(0xff4471D1)) else Modifier)
            .background(
                if (currentState) enabledColor else Color.White,
                shape = CircleShape)
            .clickable(
                onClick = { currentState = !currentState },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        contentAlignment = Alignment.Center
    ) {
            Icon(
                modifier = Modifier
                    .size(12.dp, 22.dp),
                contentDescription = "Value Icon",
                painter = iconPainter,
                tint = if (currentState) Color.White else enabledColor,
            )
    }
}

@Composable
fun ValueMedium(
    enabled: Boolean = DefaultEnabled.current,
    enabledColor: Color = DefaultEnabledColor.current,
    iconPainter: Painter,
) {
    var currentState by remember { mutableStateOf(enabled) }
    Box(
        modifier = Modifier
            .size(50.dp)
            .then(if (!currentState) Modifier.shadow(50.dp, RoundedCornerShape(50.dp), ambientColor = Color(0xff607C8E), spotColor = Color(0xff4471D1)) else Modifier)
            .background(
                if (currentState) enabledColor else Color.White,
                shape = CircleShape)
            .clickable(
                onClick = { currentState = !currentState },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(14.dp, 24.dp),
            contentDescription = "Value Icon",
            painter = iconPainter,
            tint = if (currentState) Color.White else enabledColor,
        )
    }
}

@Composable
fun ButtonCard(
    enabled: Boolean = DefaultEnabled.current,
    enabledColor: Color = DefaultEnabledColor.current,
    iconPainter: Painter,
) {
    var currentState by remember { mutableStateOf(enabled) }
    Box(
        modifier = Modifier
            .size(56.dp, 36.dp)
            .border(
                if (currentState) 10.dp else 0.dp,
                if (currentState) Color.Transparent else enabledColor,
                shape = RoundedCornerShape(12)
            )
            .then(if (currentState) Modifier.shadow(20.dp, RoundedCornerShape(20.dp), ambientColor = Color(0xff607C8E), spotColor = Color(0xff4471D1)) else Modifier)
            .background(
                Color.White,
                shape = RoundedCornerShape(12))
            .clickable(
                onClick = { currentState = !currentState },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(30.dp, 19.dp),
            contentDescription = "Card Icon",
            painter = iconPainter,
            tint = Color.Unspecified
        )
    }
}