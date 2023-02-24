package com.example.composebeginner

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.*
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomStrip() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = colorResource(id = R.color.purple_200)),
        horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .width(36.dp)
                .height(36.dp)
                .padding(5.dp)
                .border(BorderStroke(1.dp, colorResource(id = R.color.black)))
                .padding(5.dp)
                .clickable {},
            contentDescription = "Expandable Image",
            colorFilter = ColorFilter.tint(colorResource(id = R.color.black))
        )
    }
}

@Preview
@Composable
fun PreviewBottomStrip() {
    BottomStrip()
}