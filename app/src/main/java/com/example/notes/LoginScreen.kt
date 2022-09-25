package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notes.databinding.ActivityLoginScreenBinding
import com.google.firebase.auth.FirebaseAuth


class LoginScreen : AppCompatActivity() {

    lateinit var binding: ActivityLoginScreenBinding


    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth= FirebaseAuth.getInstance()
        binding.Register.setOnClickListener {
            var intent = Intent(this,RegisterScreen::class.java)
            startActivity(intent)
            finish()
        }

        val logedin : Button= findViewById(R.id.Login)
        val mail : EditText= findViewById(R.id.Email)
        val pass : EditText= findViewById(R.id.Password)
        logedin.setOnClickListener {
            if(checking()){
                val email=mail.text.toString()
                val password= pass.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            var intent = Intent(this,MainActivity::class.java)
                            intent.putExtra("email",email)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Wrong Email Or Password", Toast.LENGTH_LONG).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"Enter Email Or Password", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun checking():Boolean
    {
        val mail : EditText= findViewById(R.id.Email)
        val pass : EditText= findViewById(R.id.Password)
        if(mail.text.toString().trim{it<=' '}.isNotEmpty()
            && pass.text.toString().trim{it<=' '}.isNotEmpty())
        {
            return true
        }
        return false
    }
}