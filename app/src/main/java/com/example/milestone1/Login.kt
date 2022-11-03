 package com.example.milestone1

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

 class Login : AppCompatActivity() {

     private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

auth = Firebase.auth

        val registertext: String TextView = findViewById (R.id.textView2_register_now)
        registertext.setOnClickListener {

            val intent = Intent (this: Register,::class.java)
            startActivity(intent)
        }
        val loginButton: Button = findViewById(R.id.button_login)

        loginButton.setOnClickListener {

            private fun performlogin () {
                // get input from user
                val email : EditText =findViewById(R.id.editText_email_login)
                val password: EditText = findViewById(R.id.editText_Password_login)

            //null checks on input
                if(email.text.isEmpty() || password.text.isEmpty()){
                    Toast.makeText(this,"please fill all fields",Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                val emailInput=email.text.toString()
                val passwordInput = password.text.toString()


                auth.signInWithEmailAndPassword(emailInput, passwordInput)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, navigate to the main
                            val intent = intent(this, MainActivity::class.java)
                            startActivity(intent)

                            Toast.makeText(baseContext, "Success",
                                Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()

                        }
                    }
                    .addOnFailureListener{
                        Toast.makeText(baseContext, "Authentication failed. ${it.localizedMessage}",
                            Toast.LENGTH_SHORT).show()

                    }



            }
        }

        //do login now
        //first add login button
    }
}