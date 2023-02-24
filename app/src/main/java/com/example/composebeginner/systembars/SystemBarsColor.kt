package com.example.composebeginner.systembars

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ComposeSystemBarColor() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Blue,
            darkIcons = useDarkIcons
        )
        onDispose {}
    }
}

@Preview
@Composable
fun PreviewSystemBarColor() {
    ComposeSystemBarColor()
}