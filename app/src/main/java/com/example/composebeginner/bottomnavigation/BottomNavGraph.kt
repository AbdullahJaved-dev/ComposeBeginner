package com.example.composebeginner.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composebeginner.CreateInputField
import com.example.composebeginner.ExpandableCard
import com.example.composebeginner.LoadImage

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(
            route = BottomBarScreen.Home.route
        ){
            ExpandableCard()
        }
        composable(
            route = BottomBarScreen.List.route
        ){
            CreateInputField()
        }
        composable(
            route = BottomBarScreen.Profile.route
        ){
            LoadImage()
        }
    }
}