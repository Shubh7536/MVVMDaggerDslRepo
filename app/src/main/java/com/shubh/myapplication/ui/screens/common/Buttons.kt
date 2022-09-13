package com.shubh.myapplication.ui.screens.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.shubh.myapplication.ui.theme.Purple200

@Composable
fun WrapButton(onClick:()->Unit,text:String){
    Button(modifier = Modifier.padding(20.dp,0.dp,20.dp,0.dp),onClick = onClick, shape = RoundedCornerShape(30), colors =ButtonDefaults.buttonColors(backgroundColor = Purple200)) {
        Text(text = text, style = TextStyle(color = Color.White))
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun FullButton(onClick:()->Unit,text:String){
    Button(modifier = Modifier.fillMaxWidth().wrapContentHeight(),onClick = onClick, shape = RoundedCornerShape(30), colors =ButtonDefaults.buttonColors(backgroundColor = Purple200)) {
        Text(text = text, style = TextStyle(color = Color.White, fontSize = TextUnit(type = TextUnitType.Sp, value = 18f)), modifier = Modifier.padding(all = 8.dp))
    }
}

