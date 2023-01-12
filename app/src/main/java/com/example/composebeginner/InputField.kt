package com.example.composebeginner

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.sharp.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateInputField() {
    var inputValue by remember {
        mutableStateOf("")
    }

    val validEmailIconTint by remember {
        derivedStateOf {
            if (inputValue.isValidEmail()) Color.Green
            else Color.DarkGray
        }
    }

    var isPasswordTransformation by remember {
        mutableStateOf(true)
    }

    val focusManager = LocalFocusManager.current

    val maxLength = 10

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(

            value = inputValue,
            onValueChange = {
                if (it.length < maxLength)
                    inputValue = it
            },
            readOnly = false,
            placeholder = {
                Text(text = "Enter password", color = Color.DarkGray)
            },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { isPasswordTransformation = !isPasswordTransformation }) {
                    Icon(
                        imageVector = if (isPasswordTransformation) Icons.Outlined.Lock else Icons.Sharp.Lock,
                        contentDescription = "",
                        tint = validEmailIconTint
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                Log.d("CreateInputField", inputValue)
                focusManager.clearFocus()
            }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .border(width = 1.dp, color = validEmailIconTint, CircleShape),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = Color.Blue,
                containerColor = Color.Transparent,
            ),
            visualTransformation = if (isPasswordTransformation) PasswordVisualTransformation()
            else VisualTransformation.None
        )
    }
}

@Composable
@Preview
fun InputFieldPreview() {
    CreateInputField()
}