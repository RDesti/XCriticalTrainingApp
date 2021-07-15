package com.example.xcriticaltrainingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mViewModel: MainViewModel

    private val errorEmail by lazy { findViewById<TextView>(R.id.textViewErrorEmail) }
    private val errorPassword by lazy { findViewById<TextView>(R.id.textViewErrorPassword)}
    private val textEmail by lazy { findViewById<EditText>(R.id.editTextEmail) }
    private val textPassword by lazy { findViewById<EditText>(R.id.editTextPassword)}
    private val buttonEnter by lazy {findViewById<Button>(R.id.buttonSignIn)}
    private val buttonRegistration by lazy {findViewById<Button>(R.id.buttonRegistration)}
    private val textViewForgotPass by lazy { findViewById<TextView>(R.id.textViewForgotPassword) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()

        textViewForgotPass.setOnClickListener{
            val transition = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(transition)
        }

        buttonRegistration.setOnClickListener {
            val intent = Intent(this, BottomNavActivity::class.java)
            startActivity(intent)
        }

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        Log.d("MyLogMainAct", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MyLogMainAct", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MyLogMainAct", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MyLogMainAct", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MyLogMainAct", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyLogMainAct", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MyLogMainAct", "onRestart")
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
            
            mViewModel.isValidPassword(textPassword.text.toString())

            if(!(mViewModel.isValidData.value)!!){
                errorPassword.visibility = View.VISIBLE
            }

            mViewModel.isValidEmail(textEmail.text.toString())

            if (!(mViewModel.isValidData.value)!!) {
                    errorEmail.visibility = View.VISIBLE
            }
        }
    }
}