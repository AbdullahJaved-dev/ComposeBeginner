package com.example.composebeginner.itempositionanimation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.composebeginner.createNamesList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposeItemPositionAnimation() {
    var namesList by rememberSaveable {
        mutableStateOf(createNamesList())
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val (namesColum, button) = createRefs()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.constrainAs(namesColum) {
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
                top.linkTo(parent.top)
                bottom.linkTo(button.top, 4.dp)
            }
        ) {
            items(
                items = namesList, key = { it }
            ) {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray.copy(0.2f))
                        .padding(horizontal = 8.dp, vertical = 12.dp)
                        .animateItemPlacement(
                            animationSpec = tween(
                                durationMillis = 600,
                                easing = FastOutSlowInEasing
                            )
                        ),
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        OutlinedButton(
            onClick = { namesList = namesList.shuffled() },
            modifier = Modifier
                .constrainAs(button) {
                    width = Dimension.fillToConstraints
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(namesColum.bottom)
                }
                .padding(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black,
            ),
            border = BorderStroke(1.5.dp, Color.Green.copy(0.8f))


        ) {
            Text(
                modifier = Modifier.padding(vertical = 4.dp),
                text = "Shuffle Names",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Normal,
            )
        }
    }

}

@Preview
@Composable
fun PreviewItemPositionAnimation() {
    ComposeItemPositionAnimation()
}