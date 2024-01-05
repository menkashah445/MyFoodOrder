package com.menkashah.foodorder.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.menkashah.foodorder.R

class SignUp : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etUser: EditText
    private lateinit var etPass: EditText
    private lateinit var ConetPass: EditText
    private lateinit var login: TextView
    private lateinit var signn: Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = Firebase.auth

        etEmail = findViewById(R.id.et_username)
        etUser = findViewById(R.id.et_email)
        etPass = findViewById(R.id.et_password)
        ConetPass = findViewById(R.id.et_confirmPassword)
        login = findViewById(R.id.tv_loginButton)
        signn = findViewById(R.id.btn_register)


        signn.setOnClickListener {
            signUpUser()
        }

        login.setOnClickListener(View.OnClickListener {
            val Intent = Intent(this, Login::class.java)
            startActivity(Intent)
        })
    }

        fun signUpUser() {
            val email = etEmail.text.toString()
            val pass = etPass.text.toString()
            val confirmPassword = ConetPass.text.toString()

            // check pass
            if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
                Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
                return
            }

            if (pass != confirmPassword) {
                Toast.makeText(
                    this,
                    "Password and Confirm Password do not match",
                    Toast.LENGTH_SHORT
                )
                    .show()
                return
            }
            // If all credential are correct
            // We call createUserWithEmailAndPassword
            // using auth object and pass the
            // email and pass in it.
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
