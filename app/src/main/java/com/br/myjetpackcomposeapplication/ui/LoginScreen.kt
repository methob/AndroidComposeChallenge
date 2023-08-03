package com.br.myjetpackcomposeapplication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.br.myjetpackcomposeapplication.R
import javax.inject.Inject


@OptIn(ExperimentalMaterialApi::class)
@Preview(showSystemUi = true)
@ExperimentalMaterial3Api
@Composable
fun LoginScreen() {

    val viewModel = hiltViewModel<MyAppViewModel>()
    viewModel.test()

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(color = Color.Green)
            .size(200.dp)
            .padding(10.dp),
        verticalArrangement = Arrangement.Top
    ) {

        var loginValue by remember { mutableStateOf(value = "") }
        var passwordValue by remember { mutableStateOf(value = "") }
        val interactionSource = remember { MutableInteractionSource() }

        BasicTextField(
            value = passwordValue,
            singleLine = true,
            modifier = Modifier
                .padding(top = 20.dp)
                .height(40.dp)
                .width(260.dp),
            textStyle = TextStyle(
                fontSize = 12.sp,
            ),
            onValueChange = {
                passwordValue = it
            }
        ) { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.border(1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(2.dp)
                )
            ) {
                TextFieldDefaults.TextFieldDecorationBox(
                    value = passwordValue,
                    innerTextField = innerTextField,
                    singleLine = true,
                    enabled = true,
                    visualTransformation = VisualTransformation.None,
                    placeholder = {  GetHintTextField(stringResource(R.string.enter_email)) },
                    interactionSource = interactionSource,
                    // keep horizontal paddings but change the vertical
                    contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                        top = 0.dp, bottom = 0.dp
                    )
                )
            }

        }

        BasicTextField(
            value = loginValue,
            singleLine = true,
            modifier = Modifier
                .padding(top = 20.dp)
                .height(40.dp)
                .width(260.dp),
            textStyle = TextStyle(
                fontSize = 12.sp,
            ),
            onValueChange = {
                loginValue = it
            }
        ) { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.border(1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(2.dp)
                )
            ) {
                TextFieldDefaults.TextFieldDecorationBox(
                    value = loginValue,
                    innerTextField = innerTextField,
                    singleLine = true,
                    enabled = true,
                    visualTransformation = VisualTransformation.None,
                    placeholder = { GetHintTextField(stringResource(R.string.enter_password)) },
                    interactionSource = interactionSource,
                    // keep horizontal paddings but change the vertical
                    contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                        top = 0.dp, bottom = 0.dp
                    )
                )
            }

        }

        Button(modifier = Modifier
            .align(Alignment.Start)
            .width(150.dp)
            .padding(top = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
                contentColor = Color.White),
            onClick = {}) {
            Text("Login")
        }
    }
}

@Composable
fun GetHintTextField(hint: String) = Text(text = hint, color = Color.Black, fontSize = 12.sp)