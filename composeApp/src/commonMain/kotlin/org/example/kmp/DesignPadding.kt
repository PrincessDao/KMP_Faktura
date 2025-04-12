package org.example.kmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.kmp.*

@Composable
fun PaddingSection(scale: Float) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextWithEllipsis(
            text = "padding",
            modifier = Modifier
                .padding(8.dp)
                .zIndex(1f),
            scale = scale
        )
        Column(
            modifier = Modifier.fillMaxWidth()
                .dashedBorderBox()
        ) {
            Padding(height = 4.dp)
            Spacer(modifier = Modifier.height(80.dp))
            Padding(height = 8.dp)
            Spacer(modifier = Modifier.height(95.dp))
            Padding(height = 10.dp)
            Spacer(modifier = Modifier.height(74.dp))
            Padding(height = 12.dp)
            Spacer(modifier = Modifier.height(80.dp))
            Padding(height = 16.dp)
            Spacer(modifier = Modifier.height(80.dp))
            Padding(height = 20.dp)
        }
    }
}