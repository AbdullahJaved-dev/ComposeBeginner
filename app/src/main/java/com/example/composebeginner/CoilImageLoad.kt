package com.example.composebeginner

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation

@Composable
fun LoadImage() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
    ) {
        val (image, box, image2) = createRefs()
        val imgSrc = rememberAsyncImagePainter(
            model = ImageRequest.Builder(
                LocalContext.current
            ).data("https://sample-videos.com/img/Sample-png-image-1mb.png")
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_foreground)
                .crossfade(1000)
                .transformations(
                    CircleCropTransformation(),
                    //RoundedCornersTransformation(50f)
                )
                .build(),
            onState = {
                when (it) {
                    is AsyncImagePainter.State.Loading -> Log.d("", "Loading")
                    is AsyncImagePainter.State.Success -> Log.d("", "Success")
                    is AsyncImagePainter.State.Error -> Log.d("", "Error")
                    else -> Log.d("", "Unknown")
                }
            }
        )


        Box(
            modifier = Modifier
                .constrainAs(box) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.ratio("1:1")
                }
                .background(Color.Blue)
        )

        Image(
            painter = imgSrc,
            contentDescription = "Coil Logo",
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(box.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    width = Dimension.percent(0.5f)
                    height = Dimension.ratio("1:1")
                },
            contentScale = ContentScale.Crop,
        )

        Image(
            painter = imgSrc,
            contentDescription = "Coil Logo",
            modifier = Modifier
                .constrainAs(image2) {
                    top.linkTo(box.bottom, margin = 8.dp)
                    start.linkTo(image.end)
                    width = Dimension.percent(0.5f)
                    height = Dimension.ratio("1:1")
                },
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
@Preview
fun PreviewImage() {
    LoadImage()
}