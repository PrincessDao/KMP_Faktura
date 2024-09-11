package org.example.project

interface NavigationController {
    fun navigate(route: String)
    fun popBackStack()
}