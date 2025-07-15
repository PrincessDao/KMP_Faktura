package com.example.kmp

import android.content.Context
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp

class ComposeUiProvider(private val context: Context) {

    fun getComposeView(type: String, params: Map<String, Any>?): View {
        val view = ComposeView(context)
        view.setContent {
            when (type) {
                "padding" -> ProvidedPadding(params)
                else -> Box(Modifier.size(100.dp).background(Color.Gray))
            }
        }
        return view
    }

}

@Composable
fun ProvidedPadding(params: Map<String, Any>?) {
    val width = (params?.get("width") as? Double)?.dp
    val height = (params?.get("height") as? Double)?.dp
    val color = (params?.get("color") as? String)?.let { Color(android.graphics.Color.parseColor(it)) }
    val visibility = (params?.get("visibility") as? Double)?.toFloat()

    CompositionLocalProvider(
        DefaultPaddingWidth provides (width ?: DefaultPaddingWidth.current),
        DefaultPaddingHeight provides (height ?: DefaultPaddingHeight.current),
        DefaultPaddingBackgroundColor provides (color ?: DefaultPaddingBackgroundColor.current),
        DefaultPaddingVisibility provides (visibility ?: DefaultPaddingVisibility.current)
    ) {
        Padding()
    }
}