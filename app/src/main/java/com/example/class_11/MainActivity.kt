package com.example.class_11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.class_11.view.Home
import com.example.class_11.view.Login
import com.example.class_11.viewmodel.LoginViewModel


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			app_navigation()
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun app_navigation() {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = "login"
	) {
		composable("login") {
			Login(LoginViewModel(), nav_controller = navController)
		}
		composable("home") {
			Home()
		}
	}
}
