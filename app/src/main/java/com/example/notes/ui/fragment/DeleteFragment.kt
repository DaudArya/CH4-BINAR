package com.example.notes.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.notes.R
import com.example.notes.databinding.FragmentDeleteBinding
import com.example.notes.databinding.FragmentEditNotesBinding
import com.example.notes.ui.ViewModel.NotesViewModel

class DeleteFragment : Fragment() {

    val viewModel : NotesViewModel by viewModels()
    val noteslama by navArgs<DeleteFragmentArgs>()
    lateinit var binding: FragmentDeleteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDeleteBinding.inflate(layoutInflater, container, false)


        return binding.root
    }




}