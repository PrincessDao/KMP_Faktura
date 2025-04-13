package org.example.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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