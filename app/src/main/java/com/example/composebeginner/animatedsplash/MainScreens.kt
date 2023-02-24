package com.example.composebeginner.animatedsplash

sealed class MainScreens(val route:String){
    object Splash:MainScreens("splash_screen")
    object Home:MainScreens("home_screen")
}
