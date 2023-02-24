package com.example.composebeginner.twofingertouch

import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun TwoFingerSwipe() {
    var text by remember { mutableStateOf("No swipe detected") }

    Box(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTransformGestures { _, pan, _, _->
                    when (pan) {
                        is GesturePhase.Start -> {
                            // Check if two fingers are touching the screen
                            if (pan.numberOfPointers == 2) {
                                // Set the starting point of the swipe
                                startPoint = pan.focal
                            }
                        }
                        is GesturePhase.Ended -> {
                            // Check if two fingers were touching the screen during the swipe
                            if (pan.numberOfPointers == 2) {
                                val endPoint = pan.origin
                                val diffX = endPoint.x - startPoint.x
                                val diffY = endPoint.y - startPoint.y
                                val direction = getGestureDirection(diffX, diffY)
                                text = "Two finger swipe detected in $direction direction"
                            }
                        }
                    }
                pan.consumeAllChanges()
            }
        }
    ) {
        Text(
            text = text,
            modifier = Modifier.offset(0.dp, 100.dp)
        )
    }
}

private var startPoint: Offset? = null

private fun getGestureDirection(diffX: Float, diffY: Float): String {
    return if (Math.abs(diffX) > Math.abs(diffY)) {
        if (diffX > 0) "right" else "left"
    } else {
        if (diffY > 0) "down" else "up"
    }
}
