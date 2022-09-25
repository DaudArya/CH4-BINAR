package com.example.notes

import android.content.ClipData
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.notes.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
//    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.FragmentContainerView)
        setupActionBarWithNavController(navController)
//
//        val sharedPref=this?.getPreferences(Context.MODE_PRIVATE)?:return
//        val isLogin=sharedPref.getString("Email","1")
//        val out : Button = findViewById(R.id.logout)
//        out.setOnClickListener {
//            sharedPref.edit().remove("Email").apply()
//            var intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//        if(isLogin=="1")
//        {
//            var email=intent.getStringExtra("email")
//            if(email!=null)
//            {
//                setText(email)
//                with(sharedPref.edit())
//                {
//                    putString("Email",email)
//                    apply()
//                }
//            }
//            else{
//                var intent = Intent(this,MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }
//        else
//        {
//            setText(isLogin)
//        }

    }

//    private fun setText(email:String?)
//    {
//        db= FirebaseFirestore.getInstance()
//        if (email != null) {
//            db.collection("USERS").document(email).get()
//                .addOnSuccessListener {
//                        tasks->
//
//                }
//        }
//
//    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }






}


//val sharedPref=this?.getPreferences(Context.MODE_PRIVATE)?:return
//val isLogin=sharedPref.getString("Email","1")
//logout.setOnClickListener {
//    sharedPref.edit().remove("Email").apply()
//    var intent = Intent(this,MainActivity::class.java)
//    startActivity(intent)
//    finish()
//}
//if(isLogin=="1")
//{
//    var email=intent.getStringExtra("email")
//    if(email!=null)
//    {
//        setText(email)
//        with(sharedPref.edit())
//        {
//            putString("Email",email)
//            apply()
//        }
//    }
//    else{
//        var intent = Intent(this,MainActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
//}
//else
//{
//    setText(isLogin)
//}
//
//}
//
//private fun setText(email:String?)
//{
//    db= FirebaseFirestore.getInstance()
//    if (email != null) {
//        db.collection("USERS").document(email).get()
//            .addOnSuccessListener {
//                    tasks->
//                name.text=tasks.get("Name").toString()
//                phone.text=tasks.get("Phone").toString()
//                emailLog.text=tasks.get("email").toString()
//
//            }
//    }
//
//}