package com.example.composebeginner.bottomnavigation

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeBottomNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navController)
        },
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.List,
        BottomBarScreen.Profile,
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar(
        containerColor = Color.Black,
        tonalElevation = 4.dp
    ) {
        screens.forEach { screen ->
            AddItem(screen, currentDestination, navHostController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    val isSelected by remember {
        mutableStateOf(
            currentDestination?.hierarchy?.any { it.route == screen.route } == true
        )
    }
    NavigationBarItem(
        label = {
            Text(
                text = screen.title,
                fontSize = if (isSelected) 14.sp else 12.sp,
                modifier = Modifier.animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
            )
        },
        icon = {
            Icon(
                imageVector = screen.icon, contentDescription = null,
                modifier = Modifier
                    .scale(
                        if (isSelected) 1.3f
                        else 1.0f
                    )
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    )
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            indicatorColor = Color.Transparent,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray
        )
    )
}

@Preview
@Composable
fun PreviewBottomNavigation() {
    ComposeBottomNavigation()
}