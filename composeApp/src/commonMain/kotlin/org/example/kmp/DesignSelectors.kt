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
import kmp_faktura.composeapp.generated.resources.ruble
import kmp_faktura.composeapp.generated.resources.visa
import kmp_faktura.composeapp.generated.resources.mastercard
import kmp_faktura.composeapp.generated.resources.mir
import org.jetbrains.compose.resources.painterResource

@Composable
fun SlidesSection(scale: Float) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextWithEllipsis(
            text = "Slides",
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
                modifier = Modifier
                    .size(375.dp, 44.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                Slider()
            }
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .size(375.dp, 44.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                Slider()
            }
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .size(375.dp, 27.dp)
                    .background(Color.White)
            ) {
                LimitSlider()
            }
        }
    }
}

@Composable
fun SelectorsButtonsSection(scale: Float) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(111.dp))
            Column(modifier = Modifier.fillMaxWidth()) {

                TextWithEllipsis(
                    text = "radiobutton and checkbox",
                    modifier = Modifier
                        .padding(8.dp)
                        .zIndex(1f),
                    scale = scale
                )
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .dashedBorderBox()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        RadioButton(enabled = false)
                        Spacer(modifier = Modifier.width(8.dp))
                        RadioButton()
                        Spacer(modifier = Modifier.width(20.dp))
                        CheckBox(enabled = false)
                        Spacer(modifier = Modifier.width(10.dp))
                        CheckBox()
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(111.dp))
            Column(modifier = Modifier.fillMaxWidth()) {

                TextWithEllipsis(
                    text = "switch",
                    modifier = Modifier
                        .padding(8.dp)
                        .zIndex(1f),
                    scale = scale
                )
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .dashedBorderBox()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Switch(enabled = false)
                        Spacer(modifier = Modifier.width(8.dp))
                        Switch()
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        TextWithEllipsis(
            text = "value",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Column(
            modifier = Modifier.fillMaxWidth()
                .dashedBorderBox()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                ValueSmall(enabled = false, iconPainter = painterResource(Res.drawable.ruble))
                Spacer(modifier = Modifier.width(15.dp))
                ValueSmall(iconPainter = painterResource(Res.drawable.ruble))
                Spacer(modifier = Modifier.width(15.dp))
                ValueMedium(enabled = false, iconPainter = painterResource(Res.drawable.ruble))
                Spacer(modifier = Modifier.width(15.dp))
                ValueMedium(iconPainter = painterResource(Res.drawable.ruble))
            }
        }
    }
}

@Composable
fun ActionsSelectorSection(scale: Float) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextWithEllipsis(
            text = "Slides",
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
                modifier = Modifier
                    .size(375.dp, 72.dp)
                    .background(Color.White),
            ) {
                ButtonCard(iconPainter = painterResource(Res.drawable.visa))
                ButtonCard(iconPainter = painterResource(Res.drawable.mastercard))
                ButtonCard(iconPainter = painterResource(Res.drawable.mir))
            }
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}