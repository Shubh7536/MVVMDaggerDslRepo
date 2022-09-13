package com.shubh.myapplication.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.shubh.myapplication.R
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navToSlider:()->Unit){
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
        Image(painter = painterResource(id = R.drawable.wordy), contentDescription = "")

        LaunchedEffect(key1 = "", block = {
            delay(2000)
            navToSlider.invoke()
        }  )



    }

}