package com.example.composebeginner.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon:ImageVector,
    //val icon2: Painter= painterResource(id = R.drawable.ic_launcher_foreground)
) {
    object Home : BottomBarScreen("home", "Home", Icons.Default.Home)
    object List : BottomBarScreen("list", "List", Icons.Default.List)
    object Profile : BottomBarScreen("profile", "Profile", Icons.Default.Person)
}
