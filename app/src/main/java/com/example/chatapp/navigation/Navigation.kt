package com.example.chatapp.navigation

import PinVerificationScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.ui.chat.ChatScreen
import com.example.chatapp.ui.home.HomeScreen
import com.example.chatapp.ui.login.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Login.route) {
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

        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(onGetPinAction = { navController.navigate("pinVerification") })
        }

        composable(
            route = Screen.PinVerification.route
        ) {
            PinVerificationScreen(onPinEntered = { navController.navigate("Home") })
        }
    }
}