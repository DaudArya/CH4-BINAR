package com.example.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.notes.SharedPreferences.SharedPreference
import com.example.notes.ui.LoginActivity
import com.example.notes.ui.ViewModel.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity() {

    var sharedPreference: SharedPreference? = null
    lateinit var navController: NavController
    val viewModel : NotesViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val navController = findNavController(R.id.FragmentContainerView)
    setupActionBarWithNavController(navController)
        sharedPreference = SharedPreference(this)

}

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.logout_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout-> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun logout(){
        sharedPreference = SharedPreference(this)
        sharedPreference!!.clearSharedPreference()
        Toast.makeText(this,"User LogOut Successfully.",Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


}




//override fun onOptionsItemSelected(item: MenuItem): Boolean {
//    if(item.itemId==R.id.logout){
//
//        val bottomSheet: BottomSheetDialog = BottomSheetDialog(requireContext(),R.style.bottomsheet_style)
//        bottomSheet.setContentView(R.layout.dialog_logout)
//
//        val textViewYes = bottomSheet.findViewById<TextView>(R.id.YesLogout)
//        val textViewNo = bottomSheet.findViewById<TextView>(R.id.NoLogout)
//
//        textViewYes?.setOnClickListener{
//            bottomSheet.dismiss()
//        }
//
//        textViewNo?.setOnClickListener{
//            bottomSheet.dismiss()
//        }
//
//
//        bottomSheet.show()
//    }
//    return super.onOptionsItemSelected(item)
//}


