package com.example.composebeginner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ComposeButton() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val gradientButton = createRef()
        Button(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .constrainAs(gradientButton) {
                    start.linkTo(parent.start, margin = 8.dp)
                    width = Dimension.percent(0.5f)
                }
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color.Red, Color.Blue, Color.Green
                        )
                    ), shape = CircleShape
                )
        ) {
            Text(
                text = "Simple Button",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun PreviewComposeButton() {
    ComposeButton()
}