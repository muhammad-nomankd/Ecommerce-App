package com.durranitech.ecomerceapp.presentation.ui.screen


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.durranitech.ecomerceapp.ui.theme.EcomerceAppTheme

@Composable
fun MainContent(navController: NavHostController) {
    EcomerceAppTheme {
        NavHost(
            navController = navController, startDestination = "Home"
        ) {
            composable("Home") { Home() }
            composable("Cart") { Cart() }
            composable("Favorite") { Favorite() }
            composable("Profile") { Profile() }
        }
    }

}