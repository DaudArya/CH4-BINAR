package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterScreen : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        auth= FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()
        val next : Button = findViewById(R.id.Continue)
        next.setOnClickListener {
            if(checking())
            {
                val mail : EditText = findViewById(R.id.email)
                val pas : EditText = findViewById(R.id.Password)
                val nama : EditText = findViewById(R.id.Name)
                var email=mail.text.toString()
                var password= pas.text.toString()
                var name=nama.text.toString()
                val user= hashMapOf(
                    "Name" to name,
                    "email" to email
                )
                val Users=db.collection("USERS")
                val query =Users.whereEqualTo("email",email).get()
                    .addOnSuccessListener {
                            tasks->
                        if(tasks.isEmpty)
                        {
                            auth.createUserWithEmailAndPassword(email,password)
                                .addOnCompleteListener(this){
                                        task->
                                    if(task.isSuccessful)
                                    {
                                        Users.document(email).set(user)
                                        val intent= Intent(this,MainActivity::class.java)
                                        intent.putExtra("email",email)
                                        startActivity(intent)
                                        finish()
                                    }
                                    else
                                    {
                                        Toast.makeText(this,"Authentication Failed", Toast.LENGTH_LONG).show()
                                    }
                                }
                        }
                        else
                        {
                            Toast.makeText(this,"User Already Registered", Toast.LENGTH_LONG).show()
                            val intent= Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
            }
            else{
                Toast.makeText(this,"Enter the Details", Toast.LENGTH_LONG).show()
            }
        }
    }







    private fun checking():Boolean{
        val mail : EditText = findViewById(R.id.email)
        val pas : EditText = findViewById(R.id.Password)
        val nama : EditText = findViewById(R.id.Name)
        if(nama.text.toString().trim{it<=' '}.isNotEmpty()
            && mail.text.toString().trim{it<=' '}.isNotEmpty()
            && pas.text.toString().trim{it<=' '}.isNotEmpty()
        )
        {
            return true
        }
        return false
    }
}