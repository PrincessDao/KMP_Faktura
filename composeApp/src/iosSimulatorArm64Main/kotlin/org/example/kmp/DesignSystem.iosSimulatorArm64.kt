package org.example.kmp

actual fun getScreenSizeProvider(): ScreenSizeProvider {
    throw UnsupportedOperationException("Screen size is not supported on JVM")
}