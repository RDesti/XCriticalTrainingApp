package com.example.xcriticaltrainingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ForgotPasswordActivity : AppCompatActivity() {
    private val errorEmailFP by lazy { findViewById<TextView>(R.id.textViewErrorEmailFP) }
    private val textEmailFP by lazy { findViewById<EditText>(R.id.editTextEmailFP) }
    private val buttonEnterFP by lazy {findViewById<Button>(R.id.buttonSend)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        initListenersForgPass()
    }

    private fun initListenersForgPass() {
        textEmailFP.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                errorEmailFP.visibility = View.INVISIBLE
            }
        })

        buttonEnterFP.setOnClickListener {
            if(textEmailFP.text.isNullOrEmpty()){
                errorEmailFP.visibility = View.VISIBLE
            }
        }
    }
}