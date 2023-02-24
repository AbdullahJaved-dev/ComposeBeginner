package com.example.composebeginner.animatedselectableitem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.composebeginner.R

@Composable
fun CreateAnimatedSelectableItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    title: String = stringResource(id = R.string.app_name),
    titleColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    titleSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    subTitle: String? = null,
    subTitleColor: Color = if (selected) MaterialTheme.colorScheme.onSurface
    else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    borderWidth: Dp = 1.dp,
    borderColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    borderShape: Shape = RoundedCornerShape(10.dp),
    icon: ImageVector = Icons.Default.CheckCircle,
    iconColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    onClick: () -> Unit = {}
) {
    Column(modifier = modifier
        .border(borderWidth, borderColor, borderShape)
        .clickable {
            onClick()
        }
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

        }
    }
}

@Preview
@Composable
fun PreviewAnimatedSelectableItem() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CreateAnimatedSelectableItem()
    }
}