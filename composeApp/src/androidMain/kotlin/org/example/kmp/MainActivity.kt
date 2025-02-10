package org.example.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity(), PlatformController {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setNavigationBarColor(Color.Black)

            App(this)
        }
    }

    override fun setStatusBarColor(color: Int) {
        window.statusBarColor = color
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(object : PlatformController {
        override fun setStatusBarColor(color: Int) {}
    })
}

class AndroidScreenSizeProvider(private val context: Context): ScreenSizeProvider {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun getScreenWidth(): Float {
        val displayMetrics = DisplayMetrics()
        val display = context.display
        display.getRealMetrics(displayMetrics)
        return displayMetrics.widthPixels.toFloat()
    }
}