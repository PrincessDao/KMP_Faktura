package com.example.kmp

import android.content.Context
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp

class ComposeUiProvider(private val context: Context) {

    fun getComposeView(type: String): View {
        val view = ComposeView(context)
        view.setContent {
            when (type) {
                "padding" -> Padding()
                else -> Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Gray)
                )
            }
        }
        return view
    }

}