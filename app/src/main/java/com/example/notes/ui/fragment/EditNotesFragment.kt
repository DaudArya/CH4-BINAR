package com.example.notes.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notes.MainActivity
import com.example.notes.Model.Notes
import com.example.notes.R
import com.example.notes.databinding.FragmentEditNotesBinding
import com.example.notes.ui.ViewModel.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_edit_notes.*
import java.util.*


class EditNotesFragment : Fragment() {
    var priority : String = "1"
    val noteslama by navArgs<EditNotesFragmentArgs>()
    lateinit var binding: FragmentEditNotesBinding
    val viewModel : NotesViewModel by viewModels()
    lateinit var navController: NavController



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentEditNotesBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)

        binding.editTitle2.setText(noteslama.data.title)
        binding.editSubitle2.setText(noteslama.data.subtitle)
        binding.editNote2.setText(noteslama.data.notes)

        when (noteslama.data.priority){
            "1" -> {
                priority = "1"
                binding.pEasy2.setImageResource(R.drawable.ic_finish)
                binding.pNormal2.setImageResource(0)
                binding.pImportant2.setImageResource(0)
            }
            "2" -> {
                priority = "2"
                binding.pEasy2.setImageResource(0)
                binding.pNormal2.setImageResource(R.drawable.ic_finish)
                binding.pImportant2.setImageResource(0)
            }
            "3" -> {
                priority = "3"
                binding.pEasy2.setImageResource(0)
                binding.pNormal2.setImageResource(0)
                binding.pImportant2.setImageResource(R.drawable.ic_finish)
            }


        }
        binding.btnEditSaveNotes2.setOnClickListener(){
            UpdateNotes(it)
        }
//        binding.btndelete.setOnClickListener(){
//            DeleteNotes(it)
//        }

        return binding.root
    }

    private fun UpdateNotes(it:View?){
        val title = binding.editTitle2.text.toString()
        val subtitle = binding.editSubitle2.text.toString()
        val notes = binding.editNote2.text.toString()
        val d = Date()
        val notesDate : CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes( noteslama.data.id,
            title=title,
            subtitle = subtitle,
            notes=notes,
            date = notesDate.toString(),noteslama.data.priority)
        viewModel.addNotes(data)
        Toast.makeText(requireContext(), "Notes Edit Successfully", Toast.LENGTH_LONG).show()
        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
    }

    fun DeleteNotes(it:View?){
        viewModel.deleteNotes(noteslama.data.id!!)
        Toast.makeText(requireContext(), "Delete Note Successfully", Toast.LENGTH_LONG).show()
        activity?.let {
            val intent = Intent(it,MainActivity::class.java)
            it.startActivity(intent)}
    }




    private fun loadFragment(homeFragment: HomeFragment) {
        val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.FragmentContainerView,homeFragment)
        transaction.commit()
    }




}