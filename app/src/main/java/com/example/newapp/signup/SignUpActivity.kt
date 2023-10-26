package com.example.newapp.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.newapp.R

class SignUpActivity : AppCompatActivity() {
    private lateinit var viewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val phoneNumber = findViewById<EditText>(R.id.editTextPhone)
        val userName = findViewById<EditText>(R.id.editTextName)
        val signUpbtn = findViewById<Button>(R.id.signUpBtn)
        signUpbtn.setOnClickListener {
            println("hiiiiiiiiii")
            var email = email.text.toString()
            var password = password.text.toString()
            var phoneNumber = phoneNumber.text.toString()
            var userName = userName.text.toString()
            var ph = phoneNumber.toInt()
            viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
//            viewModel.makeApiRequest(email,password,phoneNumber,userName)
            viewModel.makeApiRequest(email, password, ph, userName)

            viewModel.liveData.observe(this) {
                println(it)
            }
        }


    }
}