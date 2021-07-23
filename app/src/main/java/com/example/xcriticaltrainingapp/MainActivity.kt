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
import com.example.xcriticaltrainingapp.databinding.ActivityBottomNavBinding
import com.example.xcriticaltrainingapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()

        binding.textViewForgotPassword.setOnClickListener{
            val transition = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(transition)
        }

        binding.buttonRegistration.setOnClickListener {
            val intent = Intent(this, BottomNavActivity::class.java)
            startActivity(intent)
        }

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel = mViewModel
    }

    private fun initListeners() {
        binding.editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.textViewErrorEmail.visibility = View.INVISIBLE
            }
        })

        binding.editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.textViewErrorPassword.visibility = View.INVISIBLE
            }
        })

        binding.buttonSignIn.setOnClickListener {

            mViewModel.isInvalidPassword(binding.editTextPassword.text.toString())

            if(mViewModel.isValidData.value!!){
                binding.textViewErrorPassword.visibility = View.VISIBLE
            }

            mViewModel.isValidEmail(binding.editTextEmail.text.toString())

            if (!(mViewModel.isValidData.value)!!) {
                binding.textViewErrorEmail.visibility = View.VISIBLE
            }
        }
    }
}