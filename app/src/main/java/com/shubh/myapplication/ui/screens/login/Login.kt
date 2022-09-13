package com.shubh.myapplication.ui.screens.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.shubh.core.base.BaseValidation
import com.shubh.myapplication.ui.screens.common.FullButton
import com.shubh.myapplication.ui.screens.common.NormalEditText
import com.shubh.myapplication.ui.screens.common.TextFieldState
import com.shubh.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class Login :BaseValidation(){
    lateinit var emailState:TextFieldState
    lateinit var validationState:MutableState<String>
    lateinit var context:Context
    private lateinit var _isValidationFailed:MutableState<Boolean>
    private var _validationFailedMessage:String=""
    @OptIn(ExperimentalUnitApi::class, ExperimentalMaterialApi::class)
    @Composable
    fun LoginScreen(navigationToSlider: () -> Unit) {
        context= LocalContext.current
        _isValidationFailed= remember {
            mutableStateOf(false)
        }
        emailState = remember { TextFieldState() }
        val mobileState = remember { TextFieldState() }
        val mContriesList = listOf("+91","+966")
        var mSelectedText by remember { mutableStateOf("+966") }
        val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
        )
        val coroutineScope: CoroutineScope = rememberCoroutineScope()
        val toggleModalBottomSheetState = {
            coroutineScope.launch {
                if (!modalBottomSheetState.isAnimationRunning) {
                    if (modalBottomSheetState.isVisible) {
                        modalBottomSheetState.hide()
                    } else {
                        modalBottomSheetState.show()
                    }
                }
            }
        }


        if (_isValidationFailed.value){
            Snackbar() {
                Text(text = _validationFailedMessage)
            }
        }

        ModalBottomSheetLayout(
            sheetState = modalBottomSheetState,
            sheetContent = {
                LazyColumn {
                    items(mContriesList) {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    mSelectedText = it
                                    toggleModalBottomSheetState()
                                }
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 12.dp,
                                ),
                        )
                    }
                }
            },
        ){
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
            ) {


                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )


                Text(
                    text = "Sign up",
                    style = TextStyle(
                        fontSize = TextUnit(30F, TextUnitType.Sp),
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "Please fill the detail and create account",
                    style = TextStyle(
                        fontSize = TextUnit(20F, TextUnitType.Sp),
                        fontWeight = FontWeight.Normal
                    )
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )

                Text(
                    text = "Name",
                    style = TextStyle(
                        fontSize = TextUnit(20F, TextUnitType.Sp),
                        fontWeight = FontWeight.Bold
                    )
                )

                NormalEditText(
                    emailState = emailState,
                    placeHolder = "Name",
                    keyboardType = KeyboardType.Email,
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )

                Text(
                    text = "Mobile Number",
                    style = TextStyle(
                        fontSize = TextUnit(20F, TextUnitType.Sp),
                        fontWeight = FontWeight.Bold
                    )
                )

                Box(
                    Modifier
                        .background(shape = RoundedCornerShape(5.dp), color = Color.LightGray)
                    ,
                    content = {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = mSelectedText,
                                Modifier
                                    .padding(10.dp)
                                    .clickable {
                                        toggleModalBottomSheetState()
                                    })
                            NormalEditText(placeHolder = "Mobile Number", keyboardType = KeyboardType.Number, emailState = mobileState, imeAction = ImeAction.Done)
                        }
                    }
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )


                FullButton(onClick = {
                    if (isScreenValidate()){

                    }
                }, text = "Next")
            }
        }
    }




    @Preview
    @Composable
    fun LoginScreenPreview() {
        MyApplicationTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                LoginScreen {

                }
            }
        }
    }

    override fun isScreenValidate(): Boolean {
        if (emailState.text.isEmpty()){
            _isValidationFailed.value=true
            _validationFailedMessage="please enter email"
            //Toast.makeText(context,"please enter email",Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
