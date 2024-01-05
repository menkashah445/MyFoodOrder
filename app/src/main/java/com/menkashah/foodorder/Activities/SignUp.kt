package com.menkashah.foodorder.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.menkashah.foodorder.R
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etUser: EditText
    private lateinit var etPass: EditText
    private lateinit var ConetPass: EditText
    private lateinit var login: TextView
    private lateinit var signn: Button
    private lateinit var auth: FirebaseAuth

    var emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$"
    var pat = Pattern.compile(emailRegex)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth
        etEmail = findViewById(R.id.et_email)
        etUser = findViewById(R.id.et_username)
        etPass = findViewById(R.id.et_password)
        ConetPass = findViewById(R.id.et_confirmPassword)
        login = findViewById(R.id.tv_loginButton)
        signn = findViewById(R.id.btn_register)

// call signup method
        signn.setOnClickListener {
            signUpUser()
        }
//loginButton to go login class
        login.setOnClickListener(View.OnClickListener {
            val Intent = Intent(this, Login::class.java)
            startActivity(Intent)
        })
    }

//Signup user function
        fun signUpUser() {
    //email password and confirm password variable value retrieved from ui
           val name = etUser.text.toString()
            val email = etEmail.text.toString()
            val pass = etPass.text.toString()
            val confirmPassword = ConetPass.text.toString()

// Log name with a tag specific to sign-up activity
                Log.d("SignUpActivity", "Name: $name")
                Log.d("SignUpActivity", "Email: $email")

            // check pass
            if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
                Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
                return
            }
              if (!pat.matcher(email).matches()) {
                    Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
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
    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
            // User creation successful
            val user = auth.currentUser
            Log.d("FirebaseAuth", "User created with email: ${user?.email}")
            Toast.makeText(this, "Successfully Signed Up", Toast.LENGTH_LONG).show()
            finish()
        } else {
            // User creation failed
            Log.e("FirebaseAuth", "User creation failed: ${task.exception?.message}")
            Toast.makeText(this, "Sign Up Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
        }
    }

}
    }
