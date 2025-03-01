package com.sena.introducctionjetpackcompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class LoginViewModel:ViewModel() {
    private val _email = MutableLiveData<String>()
    val email:LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password:LiveData<String> = _password

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin:LiveData<Boolean> = _isLogin

    // Lógica de validación
    fun onLoginChange(email:String, password:String) {
        _email.value = email
        _password.value = password
        _isLogin.value = isValidEmail(email) && isValidPassword(password)
    }
    private fun isValidEmail(email: String): Boolean {
        return email == "walter.medina@gmail.com"
    }
    private fun isValidPassword(password: String): Boolean {
        return password == "123456"
    }

}