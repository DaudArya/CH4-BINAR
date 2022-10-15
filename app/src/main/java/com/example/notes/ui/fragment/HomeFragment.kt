package com.example.notes.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notes.R
import com.example.notes.SharedPreferences.SharedPreference
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.ui.ViewModel.NotesViewModel
import com.example.notes.ui.adapter.NotesAdapter


class HomeFragment : Fragment() {
    var sharedPreference: SharedPreference? = null
    lateinit var binding: FragmentHomeBinding
    val viewModel : NotesViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
//        binding.viewmodel = viewModel
//        binding.lifecycleOwner = this
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

    fun getImportant(){
        viewModel.getImportantNotes().observe(viewLifecycleOwner,{ noteslist ->
            binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
            binding.rcvAllNotes.adapter= NotesAdapter(requireContext(),noteslist)
        })
    }







}









