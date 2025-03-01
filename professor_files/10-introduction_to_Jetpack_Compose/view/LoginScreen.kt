package com.sena.introducctionjetpackcompose.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sena.introducctionjetpackcompose.R
import com.sena.introducctionjetpackcompose.ui.theme.PurpleGrey80
import com.sena.introducctionjetpackcompose.ui.theme.Red50
import com.sena.introducctionjetpackcompose.viewmodel.LoginViewModel
@Composable
fun LoginScreen(loginViewModel: LoginViewModel, navController: NavController) {
    val context = LocalContext.current
    val email:String by loginViewModel.email.observeAsState(initial = "")
    val password:String by loginViewModel.password.observeAsState(initial = "")
    val isLogin:Boolean by loginViewModel.isLogin.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ViewTittle()
        ViewImage()
        ViewBoxEmail(email) { email ->
            loginViewModel.onLoginChange(email, password)
        }
        ViewPassword(password) { password ->
            loginViewModel.onLoginChange(email, password)
        }
        Spacer(modifier = Modifier.height(60.dp))
        ViewButton(isLogin,navController, context)
    }
}

@Composable
fun ViewTittle() {
    Text(
        text = "My Login",
        color = Color.White,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    )
}

@Composable
fun ViewImage() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo_login),
            contentDescription = "Logo Login"
        )
    }
}

@Composable
fun ViewBoxEmail(
    email:String,
    onEmailChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 15.dp),
        value = email,
        onValueChange = {onEmailChange(it)},
        label = { Text(text = "Email") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White, // Borde al enfocar
            unfocusedBorderColor = PurpleGrey80, // Borde sin enfocar
            focusedTextColor = Color.White,//Color Texto al enfocar
            unfocusedTextColor = Color.White,//Color texto sin enfocar
            focusedLabelColor = Color.Green,//Color hint al enfocar
            unfocusedLabelColor = PurpleGrey80,//Color hint sin enfocar
            cursorColor = Color.White, // Color del cursor
        )
    )
}

@Composable
fun ViewPassword(
    password: String,
    onPassWordChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 15.dp),
        value = password,
        onValueChange = {onPassWordChange(it)},
        label = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions.Default
            .copy(keyboardType = KeyboardType.NumberPassword),//solo muestre el teclado numérico
        visualTransformation = PasswordVisualTransformation(),//para ocultar la contraseña
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White, // Borde al enfocar
            unfocusedBorderColor = PurpleGrey80, // Borde sin enfocar
            focusedTextColor = Color.White,//Color Texto al enfocar
            unfocusedTextColor = Color.White,//Color texto sin enfocar
            focusedLabelColor = Color.Green,//Color hint al enfocar
            unfocusedLabelColor = PurpleGrey80,//Color hint sin enfocar
            cursorColor = Color.White, // Color del cursor
        )
    )
}

@Composable
fun ViewButton(
    isLogin: Boolean,
    navController: NavController,
    context: Context
) {
    Button(
        onClick = {
            if (isLogin){
                navController.navigate("home")
            }else{
                Toast.makeText(context,"Login incorrecto",Toast.LENGTH_LONG).show()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        colors = ButtonDefaults.buttonColors(Red50)
    ) {
        Text(text = "Iniciar Sesión", fontSize = 16.sp)
    }
}



