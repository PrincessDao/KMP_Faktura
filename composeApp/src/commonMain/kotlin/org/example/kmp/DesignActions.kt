package org.example.kmp

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kmp_faktura.composeapp.generated.resources.Res
import kmp_faktura.composeapp.generated.resources.facebook
import kmp_faktura.composeapp.generated.resources.favorites
import kmp_faktura.composeapp.generated.resources.instagram
import kmp_faktura.composeapp.generated.resources.massage_big
import kmp_faktura.composeapp.generated.resources.repeat
import kmp_faktura.composeapp.generated.resources.telegram
import kmp_faktura.composeapp.generated.resources.twitter
import kmp_faktura.composeapp.generated.resources.viber
import kmp_faktura.composeapp.generated.resources.vk
import kmp_faktura.composeapp.generated.resources.whatsapp
import kmp_faktura.composeapp.generated.resources.withdraw
import org.jetbrains.compose.resources.painterResource
import com.example.functions.*


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

        Box(
            modifier = Modifier
                .size(375.dp, 21.dp)
                .background(Color.White)
        ) {
            DotBanner()
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextWithEllipsis(
            text = "row/dot personal offer",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Box(
            modifier = Modifier
                .size(375.dp, 53.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(375.dp, 21.dp)
                    .background(Color.White)
            ) {
                DotPersonalOffer()
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(375.dp, 76.dp)
                .background(Color.White)
        ) {
                ActionDown()
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextWithEllipsis(
            text = "action / up",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(375.dp, 76.dp)
                .background(Color.White)
        ) {
                ActionUp()
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextWithEllipsis(
            text = "action / roll up",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Box(
            modifier = Modifier
                .size(375.dp, 52.dp)
                .background(Color.White)
        ) {
            ActionRollUp()
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextWithEllipsis(
            text = "action / slider",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(375.dp, 44.dp)
                .background(Color.White)
        ) {
            ActionSlider()
        }
    }
}

@Composable
fun ActionsRowSection(scale: Float) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextWithEllipsis(
            text = "row",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Column(
            modifier = Modifier.fillMaxWidth()
                .dashedBorderBox()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(375.dp, 114.dp)
                    .background(Color(0xFF4C85FF))
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 12.dp)
                ) {
                    ActionRow(
                        text = "В шаблон",
                        textColor = Color.White,
                        iconPainter = painterResource(Res.drawable.massage_big),
                        iconColor = Color.White,
                        circleColor = Color.White,
                        circleVisibility = 0.1f
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Выслать чек",
                        textColor = Color.White,
                        iconPainter = painterResource(Res.drawable.favorites),
                        iconColor = Color.White,
                        circleColor = Color.White,
                        circleVisibility = 0.1f
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Повторить",
                        textColor = Color.White,
                        iconPainter = painterResource(Res.drawable.repeat),
                        iconColor = Color.White,
                        circleColor = Color.White,
                        circleVisibility = 0.1f
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Отменить",
                        textColor = Color.White,
                        iconPainter = painterResource(Res.drawable.withdraw),
                        iconColor = Color.White,
                        circleColor = Color.White,
                        circleVisibility = 0.1f
                    )
                }
            }
            Spacer(modifier = Modifier.height(54.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(375.dp, 128.dp)
                    .background(Color.White)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 12.dp)
                ) {
                    ActionRow(
                        text = "Выслать\nчек",
                        iconPainter = painterResource(Res.drawable.massage_big),
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Сохранить\nв шаблон",
                        iconPainter = painterResource(Res.drawable.favorites),
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Повторить",
                        iconPainter = painterResource(Res.drawable.repeat),
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Отменить",
                        iconPainter = painterResource(Res.drawable.withdraw),
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(375.dp, 128.dp)
                    .background(Color.White)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 12.dp)
                ) {
                    ActionRow(
                        text = "Выслать\nчек",
                        iconPainter = painterResource(Res.drawable.massage_big),
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Сохранить\nв шаблон",
                        iconPainter = painterResource(Res.drawable.favorites),
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Повторить",
                        iconPainter = painterResource(Res.drawable.repeat),
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(375.dp, 128.dp)
                    .background(Color.White)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 12.dp)
                ) {
                    ActionRow(
                        text = "Выслать\nчек",
                        iconPainter = painterResource(Res.drawable.massage_big),
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ActionRow(
                        text = "Сохранить\nв шаблон",
                        iconPainter = painterResource(Res.drawable.favorites),
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(375.dp, 128.dp)
                    .background(Color.White)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 12.dp)
                ) {
                    ActionRow(
                        text = "Выслать\nчек",
                        iconPainter = painterResource(Res.drawable.massage_big),
                    )
                }
            }
        }
    }
}

@Composable
fun SocialRowSection(scale: Float) {


    Column(modifier = Modifier.fillMaxWidth()) {
        TextWithEllipsis(
            text = "row / social 1 line",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Social1Line()
        Spacer(modifier = Modifier.height(16.dp))

        TextWithEllipsis(
            text = "row / social 2 line",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Social2Line()
    }
}

@Composable
fun Social1Line() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(472.dp, 72.dp)
            .background(Color.White)
    ) {
        SocialLine()
    }
}

@Composable
fun Social2Line() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(472.dp, 136.dp)
            .background(Color.White)
    ) {
        Column{
            SocialLine()
            Spacer(modifier = Modifier.height(16.dp))
            SocialLine()
        }
    }
}

@Composable
fun SocialLine() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialRow(iconPainter = painterResource(Res.drawable.facebook))
        Spacer(modifier = Modifier.width(16.dp))
        SocialRow(iconPainter = painterResource(Res.drawable.vk))
        Spacer(modifier = Modifier.width(16.dp))
        SocialRow(iconPainter = painterResource(Res.drawable.twitter))
        Spacer(modifier = Modifier.width(16.dp))
        SocialRow(iconPainter = painterResource(Res.drawable.telegram))
        Spacer(modifier = Modifier.width(16.dp))
        SocialRow(iconPainter = painterResource(Res.drawable.instagram))
        Spacer(modifier = Modifier.width(16.dp))
        SocialRow(iconPainter = painterResource(Res.drawable.viber))
        Spacer(modifier = Modifier.width(16.dp))
        SocialRow(iconPainter = painterResource(Res.drawable.whatsapp))
    }
}