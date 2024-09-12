package org.example.scrprofile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform