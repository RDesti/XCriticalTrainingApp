package com.example.xcriticaltrainingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private val errorEmail by lazy { findViewById<TextView>(R.id.textViewErrorEmail) }
    private val errorPassword by lazy { findViewById<TextView>(R.id.textViewErrorPassword)}
    private val textEmail by lazy { findViewById<EditText>(R.id.editTextEmail) }
    private val textPassword by lazy { findViewById<EditText>(R.id.editTextPassword)}
    private val buttonEnter by lazy {findViewById<Button>(R.id.buttonSignIn)}
    private val textViewForgotPass by lazy { findViewById<TextView>(R.id.textViewForgotPassword) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()

        textViewForgotPass.setOnClickListener{
            val transition = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(transition)
        }
    }

    private fun initListeners() {
        textEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                errorEmail.visibility = View.INVISIBLE
            }
        })

        textPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                errorPassword.visibility = View.INVISIBLE
            }
        })

        buttonEnter.setOnClickListener {
            if(textEmail.text.isNullOrEmpty() || !(isEmailValid(textEmail.text.toString()))){
                errorEmail.visibility = View.VISIBLE
            }

            if(textPassword.text.isNullOrEmpty()){
                errorPassword.visibility = View.VISIBLE
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
            """^[^@\s\.]+@[^@\s]+\.[^@\s]+$"""
        ).matcher(email).matches()
    }
}