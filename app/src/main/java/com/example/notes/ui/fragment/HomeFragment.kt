package com.example.notes.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notes.R
import com.example.notes.SharedPreferences.SharedPreference
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.ui.LoginActivity
import com.example.notes.ui.ViewModel.NotesViewModel
import com.example.notes.ui.adapter.NotesAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    var sharedPreference: SharedPreference? = null
//    private val viewModel by lazy { ViewModelProviders.of(this).get(NotesViewModel::class.java) }

    lateinit var binding: FragmentHomeBinding

    val viewModel : NotesViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner,{ noteslist ->
            binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
            binding.rcvAllNotes.adapter= NotesAdapter(requireContext(),noteslist)

        })
        binding.filternote.setOnClickListener(){
            viewModel.getNotes().observe(viewLifecycleOwner,{ noteslist ->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rcvAllNotes.adapter= NotesAdapter(requireContext(),noteslist)

            })
        }

        binding.textcommon.setOnClickListener(){

            viewModel.getCommonNotes().observe(viewLifecycleOwner,{ noteslist ->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rcvAllNotes.adapter= NotesAdapter(requireContext(),noteslist)

            })
        }

        binding.textnormal.setOnClickListener(){
            viewModel.getNormalNotes().observe(viewLifecycleOwner,{ noteslist ->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rcvAllNotes.adapter= NotesAdapter(requireContext(),noteslist)

            })
        }
        binding.textimportant.setOnClickListener(){
            viewModel.getImportantNotes().observe(viewLifecycleOwner,{ noteslist ->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rcvAllNotes.adapter= NotesAdapter(requireContext(),noteslist)

            })
        }


        binding.btnAddNotes.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNoteFragment2)
        }


        return binding.root
    }







}









