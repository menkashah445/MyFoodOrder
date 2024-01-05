package com.menkashah.foodorder.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.menkashah.foodorder.R

class ResetPassword : AppCompatActivity() {

//    var et_sendEmail: EditText? = null
    private lateinit var et_sendEmail:EditText
//    var btn_reset: Button? = null
    private lateinit var btn_reset: Button
    var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        et_sendEmail = findViewById(R.id.et_sendEmail)
        btn_reset = findViewById(R.id.btn_reset)
        firebaseAuth = FirebaseAuth.getInstance()



        btn_reset.setOnClickListener(View.OnClickListener {
            val email = et_sendEmail.getText().toString()
            if (email == "") {
                Toast.makeText(
                    this,
                    "Email is empty",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                firebaseAuth!!.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "Please Check Your Email",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(
                            Intent(
                                this,
                                Login::class.java
                            )
                        )
                    } else {
                        val error = task.exception!!.message
                        Toast.makeText(
                            this,
                            error,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
        })

    }
}