package com.shubh.myapplication.ui.screens.slider

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.shubh.data.model.SliderData
import com.shubh.myapplication.R
import com.shubh.myapplication.ui.screens.common.WrapButton
import kotlinx.coroutines.launch

private fun createSliderData()= listOf<SliderData>(
    SliderData(R.drawable.group,"Welcome to the world of knowledge","We will help you gain knowledge that will" +
            "change your life.Learn new words daily."),
    SliderData(R.drawable.capa_1,"Learn online from your home","Learn a lot of new skills with our interesting lessons."),
    SliderData(R.drawable.group_815,"Learn on your time schedule","Learn different types of\n" +
            "Word with new library every month."),

)
@OptIn(ExperimentalPagerApi::class, ExperimentalUnitApi::class)
@Composable
fun SliderScreen(natToLogin : ()->Unit){

    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

        val sliderData= createSliderData()
        val pagerState= rememberPagerState()

        HorizontalPager(count = sliderData.size,
        state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) { currentPage->
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp)
            , verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

                Image(painter = painterResource(id = sliderData[currentPage].image), contentDescription = "",
                    Modifier
                        .height(200.dp)
                        .width(200.dp))


                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))

                Text(modifier = Modifier.padding(40.dp,0.dp,40.dp,0.dp),text = sliderData[currentPage].title, style = TextStyle(color = Color.Black, textAlign = TextAlign.Center, fontSize = TextUnit(26f, type = TextUnitType.Sp)))

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))

                Text(modifier = Modifier.padding(40.dp,0.dp,40.dp,0.dp),text = sliderData[currentPage].description, style = TextStyle(color = Color.DarkGray, textAlign = TextAlign.Center, fontSize = TextUnit(18f, type = TextUnitType.Sp)))

            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
        )

        val coroutineScope= rememberCoroutineScope()
        WrapButton(onClick = {
            coroutineScope.launch {
                if (pagerState.currentPage!=sliderData.size-1)
                    pagerState.animateScrollToPage(pagerState.currentPage+1)
                else
                    natToLogin.invoke()
            }
        },"Next")

    }
}