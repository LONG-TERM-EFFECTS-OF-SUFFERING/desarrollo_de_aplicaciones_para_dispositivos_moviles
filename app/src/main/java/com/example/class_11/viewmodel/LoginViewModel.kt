package com.example.class_11.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel: ViewModel() {
	private val _email = MutableLiveData<String>()
	val email: LiveData<String> = _email

	private val _password = MutableLiveData<String>()
	val password: LiveData <String> = _password

	private val _is_logged_in = MutableLiveData<Boolean>()
	val is_logged_in: LiveData <Boolean> = _is_logged_in


	fun on_login_change(email: String, password: String) {
		_email.value = email
		_password.value = password
		_is_logged_in.value = is_valid_email(email) && is_valid_password(password)
	}

	private fun is_valid_email(email: String): Boolean {
		return email == "walter.medina@gmail.com"
	}

	private fun is_valid_password(password: String): Boolean {
		return password == "123456"
	}
}
