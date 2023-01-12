package com.example.composebeginner

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ComposeLazyColumn(items: List<String>, onItemClick: (Int, String) -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
        //.verticalScroll(rememberScrollState())
    ) {
        val lcNames = createRef()
        LazyColumn(
            modifier = Modifier.constrainAs(lcNames) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            },
            contentPadding = PaddingValues(all = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(
                items = items
            ) { position, data ->
                LazyItem(value = data, position) { p, d ->
                    onItemClick(p, d)
                }
            }
        }
    }
}

@Composable
fun LazyItem(value: String, position: Int, onItemClick: (Int, String) -> Unit) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .clickable {
                onItemClick(position, value)
            },
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Italic,
    )
}

fun createNamesList(): List<String> {
    val namesList = mutableListOf<String>()
    for (i in 0..100) {
        namesList.add("Abdullah $i")
    }
    return namesList
}

@Preview
@Composable
fun PreviewLazyColumn() {
    ComposeLazyColumn(createNamesList()) { p, s ->

    }
}