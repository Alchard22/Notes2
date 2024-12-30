package com.plcoding.improvednotesapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform