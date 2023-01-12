package com.example.composebeginner

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard() {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .animateContentSize(animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)), shape = MaterialTheme.shapes.medium,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = "Title",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                IconButton(
                    modifier = Modifier
                        .alpha(1.0f)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow",
                    )
                }
            }

            if (expandedState) {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                            "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Justify
                )
            }
        }

    }
}

@Composable
@Preview
fun ShowExpandableCard() {
    ExpandableCard()
}