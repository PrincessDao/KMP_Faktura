package org.example.kmp
import android.content.res.Resources

class JvmScreenSizeProvider : ScreenSizeProvider {
    override fun getScreenWidth(): Float {
        val displayMetrics = Resources.getSystem().displayMetrics
        return displayMetrics.widthPixels / displayMetrics.density
    }

}

actual fun getScreenSizeProvider(): ScreenSizeProvider {
    return JvmScreenSizeProvider()
}