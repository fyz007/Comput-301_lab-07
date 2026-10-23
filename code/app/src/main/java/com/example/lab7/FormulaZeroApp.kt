package com.example.lab7

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FormulaZeroApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") { HomeScreen(navController) }
        composable("races") { UpcomingRacesScreen(navController) }
        composable("drivers") { DriversScreen(navController) }
    }
}