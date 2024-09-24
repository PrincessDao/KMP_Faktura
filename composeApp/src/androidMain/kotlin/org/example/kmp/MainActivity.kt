package org.example.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity()/*, PlatformController*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.navigationBarColor = 0xFFFFFFFF.toInt()
        setContent {
            App(/*this*/)
        }
    }

    /*override fun setStatusBarColor(color: Int) {
        window.statusBarColor = color
    }*/
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(/*object : PlatformController {
        override fun setStatusBarColor(color: Int) {}
    }*/)
}