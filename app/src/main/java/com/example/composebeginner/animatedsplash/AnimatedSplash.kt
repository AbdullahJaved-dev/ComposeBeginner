package com.example.composebeginner.animatedsplash

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composebeginner.bottomnavigation.ComposeBottomNavigation
import kotlinx.coroutines.delay

@Composable
fun ComposeAnimatedSplash() {
    val navController = rememberNavController()
    SetUpNavGraph(navController)
}

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainScreens.Splash.route) {
        composable(MainScreens.Splash.route) {
            AnimatedSplash(navController = navController)
        }

        composable(MainScreens.Home.route) {
            ComposeBottomNavigation()
        }
    }
}

@Composable
fun AnimatedSplash(navController: NavHostController) {
    var startAnimation by rememberSaveable {
        mutableStateOf(false)
    }

    val offsetAnimation = animateDpAsState(
        targetValue = 150.dp,
        animationSpec = tween(durationMillis = 3000)
    )

    val alphaAnimation = animateFloatAsState(
        targetValue =
        if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(MainScreens.Home.route)
    }
    Splash(alphaAnimation.value, offsetAnimation.value)
}

@Composable
fun Splash(alphaAnimation: Float, value: Dp) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home Icon",
            tint = Color.Black,
            modifier = Modifier
                .size(120.dp)
                //.alpha(alphaAnimation)
                .offset(value, 0.dp)
        )
    }
}

@Preview
@Composable
fun PreviewAnimatedSplash() {
    Splash(1f, 150.dp)
}