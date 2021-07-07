package com.example.xcriticaltrainingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val errorEmail by lazy { findViewById<TextView>(R.id.textViewErrorEmail) }
    private val errorPassword by lazy { findViewById<TextView>(R.id.textViewErrorPassword)}
    private val textEmail by lazy { findViewById<EditText>(R.id.editTextEmail) }
    private val textPassword by lazy { findViewById<EditText>(R.id.editTextPassword)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun checkEmailText(view: View){
        textEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                errorEmail.visibility = View.INVISIBLE
            }
        })
    }

    fun checkPasswordText(view: View){
        textPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                errorPassword.visibility = View.INVISIBLE
            }
        })
    }

    fun showSignInWindow(view: View){
        if(textEmail.text.isNullOrEmpty()){
            errorEmail.visibility = View.VISIBLE
        }

        if(textPassword.text.isNullOrEmpty()){
            errorPassword.visibility = View.VISIBLE
        }
    }


}