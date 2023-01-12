package com.example.composebeginner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composebeginner.bottomnavigation.ComposeBottomNavigation
import com.example.composebeginner.ui.theme.ComposeBeginnerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBeginnerTheme {
                ComposeBottomNavigation()
            }
        }
    }
}
/*@Composable
fun PrintName(name: String) {
    Text(
        text = name,
        style = Typography.bodyMedium
    )
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!"
    )
}*/

/*@Composable
fun ColumnScope.CustomSurface(weight: Float, color: Color, content: () -> Unit = { }) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color
    ) {
        content.invoke()
    }
}

@Composable
fun RowScope.CustomSurface(weight: Float, color: Color, content: () -> Unit = { }) {
    Surface(
        modifier = Modifier
            .weight(weight)
            .height(60.dp),
        color = color
    ) {
        content.invoke()
    }
}

Column(modifier = Modifier.fillMaxSize()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomSurface(weight = 3f, color = MaterialTheme.colorScheme.secondary)
        CustomSurface(weight = 1f, color = MaterialTheme.colorScheme.primary)

    }

    Row(
        modifier = Modifier
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Start
    ) {
        CustomSurface(weight = 3f, color = MaterialTheme.colorScheme.secondary)
        CustomSurface(weight = 1f, color = MaterialTheme.colorScheme.primary)
    }
}*/
/*
Box(
modifier = Modifier
.fillMaxSize()
.background(MaterialTheme.colorScheme.background),
contentAlignment = Alignment.TopCenter
) {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .width(100.dp)
            .height(100.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "I love Android", fontSize = 40.sp, color = Color.White)

    }

}*/

/**
 * Text Decoration
 * Text from resource
 * Spannable String
 * Ellipsis String
 * Selectable String
 * SuperScript/SubScript Text
 */
/*Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(16.dp),
                color = Color.White,
                style = Typography.bodyMedium
            )

            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    ) {
                        append("A")
                    }
                    append("B")
                    append("C")
                    append("D")
                }, modifier = Modifier
                    .width(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray)
                    .padding(10.dp),
                textAlign = TextAlign.Center
            )

            Text(
                maxLines = 2,
                text = "Hello World".repeat(20),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan)
                    .padding(10.dp),
                textAlign = TextAlign.Justify,
                overflow = TextOverflow.Ellipsis,
            )

            SelectionContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(10.dp)
            ) {
                Column {
                    Text(text = "Selectable", color = Color.White)
                    DisableSelection {
                        Text(text = "Not Selectable", color = Color.White)
                    }
                    Text(text = "Selectable", color = Color.White)
                }
            }

            SelectionContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Column {
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                                )
                            ) {
                                append("2")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                                    fontWeight = FontWeight.Normal,
                                    baselineShift = BaselineShift.Superscript
                                )
                            ) {
                                append("2")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                                )
                            ) {
                                append(" = 4")
                            }
                        }
                    )

                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                                )
                            ) {
                                append("log")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                                    fontWeight = FontWeight.Normal,
                                    baselineShift = BaselineShift.Subscript
                                )
                            ) {
                                append("10")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                                )
                            ) {
                                append("1 = 0")
                            }
                        }
                    )
                }
            }

        }*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBeginnerTheme {
        ComposeButton()
    }
}


