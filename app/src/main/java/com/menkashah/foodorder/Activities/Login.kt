package com.menkashah.foodorder.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.menkashah.foodorder.R

class Login : AppCompatActivity() {

    lateinit var etEmail: EditText
//    lateinit var etUser: EditText
    private lateinit var etPass: EditText
    private lateinit var login: Button
    lateinit var Signup: TextView
    lateinit var forgotpass: TextView
    private lateinit var auth: FirebaseAuth


    var emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()


        etEmail = findViewById(R.id.et_email)
//        etUser = findViewById(R.id.et_email)
        etPass = findViewById(R.id.et_password)
        login = findViewById(R.id.btn_login)
        Signup = findViewById(R.id.SIGNUP)
        forgotpass = findViewById(R.id.tv_forgotPassword)

        forgotpass.setOnClickListener {
            val intent = Intent(this, ResetPassword::class.java)
            startActivity(intent)
        }


        Signup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }


        login.setOnClickListener(View.OnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPass.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            Toast.makeText(this, "Authentication successful.", Toast.LENGTH_SHORT)
                                .show()
                            // TODO: Navigate to the next activity or perform other actions
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }


                    }
            }
        })
    }
}