package com.example.xcriticaltrainingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class MainViewModel() : ViewModel() {

    private val _isValidData = MutableLiveData<Boolean>()
    val isValidData: LiveData<Boolean>
    get() = _isValidData

    fun isValidEmail(email: String) {
        _isValidData.value = (Pattern.compile(
            """^[^@\s\.]+@[^@\s]+\.[^@\s]+$"""
        ).matcher(email).matches())
                && (email.isNotEmpty())
    }

    fun isInvalidPassword(password: String){
        _isValidData.value = password.isEmpty()
    }
}