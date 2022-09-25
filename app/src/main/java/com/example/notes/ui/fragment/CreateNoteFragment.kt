package com.example.notes.ui.fragment

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.notes.Model.Notes
import com.example.notes.R
import com.example.notes.databinding.FragmentCreateNoteBinding
import com.example.notes.ui.ViewModel.NotesViewModel

import java.util.*


class CreateNoteFragment : Fragment() {
    lateinit var binding: FragmentCreateNoteBinding
     var priority : String = "1"
     val viewModel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNoteBinding.inflate(layoutInflater, container, false)
        binding.pEasy.setImageResource(R.drawable.ic_finish)
        binding.pEasy.setOnClickListener(){
            priority = "1"
            binding.pEasy.setImageResource(R.drawable.ic_finish)
            binding.pNormal.setImageResource(0)
            binding.pImportant.setImageResource(0)
        }

        binding.pNormal.setOnClickListener(){
            priority = "2"
            binding.pEasy.setImageResource(0)
            binding.pNormal.setImageResource(R.drawable.ic_finish)
            binding.pImportant.setImageResource(0)
        }
        binding.pImportant.setOnClickListener(){
            priority = "3"
            binding.pEasy.setImageResource(0)
            binding.pNormal.setImageResource(0)
            binding.pImportant.setImageResource(R.drawable.ic_finish)
        }

        binding.btnEditSaveNotes.setOnClickListener(){
            createNotes(it)
    }
return binding.root

}

    private fun createNotes(it:View?){
        val title = binding.editTitle.text.toString()
        val subtitle = binding.editSubitle.text.toString()
        val notes = binding.editNote.text.toString()
        val d = Date()
        val notesDate : CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes( null,
            title=title,
            subtitle = subtitle,
            notes=notes,
            date = notesDate.toString(),priority)
        viewModel.addNotes(data)
        Toast.makeText(requireContext(), "Notes Created Successfully", Toast.LENGTH_LONG).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_homeFragment)
    }
}