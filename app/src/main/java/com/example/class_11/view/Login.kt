package com.example.class_11.view

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
import androidx.navigation.NavController
import com.example.class_11.R
import com.example.class_11.ui.theme.PurpleGrey80
import com.example.class_11.ui.theme.Red50
import com.example.class_11.viewmodel.LoginViewModel


@Composable
fun Login(login_view_model: LoginViewModel, nav_controller: NavController) {
	val context = LocalContext.current
	val email: String by login_view_model.email.observeAsState(initial = "")
	val password: String by login_view_model.password.observeAsState(initial = "")
	val is_logged_in: Boolean by login_view_model.is_logged_in.observeAsState(initial = false)

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Black)
	) {
		ViewTittle()
		ViewImage()
		ViewBoxEmail(email) { email ->
			login_view_model.on_login_change(email, password)
		}
		ViewPassword(password) { password ->
			login_view_model.on_login_change(email, password)
		}
		Spacer(modifier = Modifier.height(60.dp))
		ViewButton(is_logged_in,nav_controller, context)
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
			painter = painterResource(id = R.drawable.ic_launcher_foreground),
			contentDescription = "Logo Login"
		)
	}
}

@Composable
fun ViewBoxEmail(
	email:String,
	on_email_change: (String) -> Unit
) {

	OutlinedTextField(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 20.dp, vertical = 15.dp),
		value = email,
		onValueChange = {on_email_change(it)},
		label = { Text(text = "Email") },
		colors = OutlinedTextFieldDefaults.colors(
			focusedBorderColor = Color.White,
			unfocusedBorderColor = PurpleGrey80,
			focusedTextColor = Color.White,
			unfocusedTextColor = Color.White,
			focusedLabelColor = Color.Green,
			unfocusedLabelColor = PurpleGrey80,
			cursorColor = Color.White,
		)
	)
}

@Composable
fun ViewPassword(
	password: String,
	on_password_change: (String) -> Unit
) {

	OutlinedTextField(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 25.dp, vertical = 15.dp),
		value = password,
		onValueChange = {on_password_change(it)},
		label = { Text(text = "Password") },
		keyboardOptions = KeyboardOptions.Default
			.copy(keyboardType = KeyboardType.NumberPassword),
		visualTransformation = PasswordVisualTransformation(),
		colors = OutlinedTextFieldDefaults.colors(
			focusedBorderColor = Color.White,
			unfocusedBorderColor = PurpleGrey80,
			focusedTextColor = Color.White,
			unfocusedTextColor = Color.White,
			focusedLabelColor = Color.Green,
			unfocusedLabelColor = PurpleGrey80,
			cursorColor = Color.White,
		)
	)
}

@Composable
fun ViewButton(
	is_logged_in: Boolean,
	nav_controller: NavController,
	context: Context
) {
	Button(
		onClick = {
			if (is_logged_in)
				nav_controller.navigate("home")
			else
				Toast.makeText(context,"unsuccessful login",Toast.LENGTH_LONG).show()
		},
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 20.dp),
		colors = ButtonDefaults.buttonColors(Red50)
	) {
		Text(text = "login", fontSize = 16.sp)
	}
}
