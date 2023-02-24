package com.example.composebeginner.effecthandlers

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ComposeEffectHandlers() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (button, text) = createRefs()

        var buttonText by rememberSaveable {
            mutableStateOf("A")
        }

        val scope = rememberCoroutineScope()

        var i = 0

        /*LaunchedEffect(Unit) {
            i++
            Log.d("", "ComposeEffectHandlers: $i")
        }*/
        Button(onClick = {
            buttonText += "A"

            scope.launch {

            }
        },

            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.percent(0.5f)

            }) {

            Text(text = buttonText, modifier = Modifier.clickable { })

        }

    }

    /* Column(
         modifier = Modifier.fillMaxWidth(),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
     ) {
         Button(onClick = { *//*TODO*//* }, shape = RoundedCornerShape(8.dp)) {
            Text(text = "Click Me", color = Color.White)
        }

    }*/
}

@Preview
@Composable
fun PreviewEffectHandlers() {
    ComposeEffectHandlers()
}