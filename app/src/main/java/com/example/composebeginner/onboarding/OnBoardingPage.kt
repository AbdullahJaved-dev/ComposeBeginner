package com.example.composebeginner.onboarding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class OnBoardingPage(
    val icon: ImageVector,
    val title: String,
    val description: String
) {
    object FIRST :
        OnBoardingPage(Icons.Default.Home, "Home", "hhakjh hkjhjkh  hjkhjh ghjgg gfglk ")

    object SECOND :
        OnBoardingPage(Icons.Default.Person, "Person", "hhakjh hkjhjkh  hjkhjh ghjgg gfglk ")

    object THIRD :
        OnBoardingPage(Icons.Default.Call, "Call", "hhakjh hkjhjkh  hjkhjh ghjgg gfglk ")
}
