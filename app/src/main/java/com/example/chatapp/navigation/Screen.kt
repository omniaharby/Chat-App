package com.example.chatapp.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String, val navArgs: List<NamedNavArgument> = emptyList()) {

    data object Home : Screen(route = "Home")
    data object Settings : Screen(route = "Settings")

    data object Login : Screen(route = "Login")

    data object PinVerification : Screen(route = "pinVerification")
    data object ChatScreen : Screen(
        route = "ChatScreen/{id}",
        navArgs = listOf(navArgument("id") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(id: String?) = "ChatScreen/${id}"
    }
}