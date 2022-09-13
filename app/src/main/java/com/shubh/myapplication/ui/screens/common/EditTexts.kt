package com.shubh.myapplication.ui.screens.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.shubh.myapplication.ui.theme.MyApplicationTheme

class TextFieldState() {
    var text: String by mutableStateOf("")
}

@Composable
fun NormalEditText(
    emailState: TextFieldState = remember { TextFieldState() },
    placeHolder: String? = null,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType=KeyboardType.Text,
    imeAction: ImeAction=ImeAction.Next
) {
    OutlinedTextField(
        value = emailState.text, onValueChange = {
            emailState.text = it
        },
        placeholder = { Text(text = placeHolder ?: "") },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.LightGray
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType,
            capitalization = KeyboardCapitalization.Characters
        ),
        maxLines = if (isSingleLine) 1 else 4,
        singleLine = isSingleLine
    )
}

@Preview
@Composable
fun NormalEditTextPreview() {
    MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NormalEditText()
        }
    }
}