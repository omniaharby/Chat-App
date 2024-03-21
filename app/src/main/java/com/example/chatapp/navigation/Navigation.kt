package com.example.chatapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.ui.chat.ChatScreen
import com.example.chatapp.ui.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onChatClick = {
                    navController.navigate(
                        Screen.ChatScreen.createRoute(
                            id = it
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.ChatScreen.route,
            arguments = Screen.ChatScreen.navArgs
        ) {
            ChatScreen(onBackClick = { navController.navigateUp() })
        }
    }
}