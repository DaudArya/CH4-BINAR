package com.example.notes.ui.ViewModel

import android.app.Application
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.navArgs
import com.example.notes.Database.NotesDatabase
import com.example.notes.MainActivity
import com.example.notes.Model.Notes
import com.example.notes.R
import com.example.notes.Repository.NotesRepository
import com.example.notes.databinding.FragmentCreateNoteBinding
import kotlinx.android.synthetic.main.fragment_create_note.view.*
import com.example.notes.databinding.FragmentEditNotesBinding
import com.example.notes.ui.fragment.CreateNoteFragment
import com.example.notes.ui.fragment.EditNotesFragmentArgs

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val repository : NotesRepository
    var priority : String = "1"

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)

    }

    fun addNotes(notes: Notes){
        repository.inserNotes(notes)
    }

    fun getNotes():LiveData<List<Notes>> = repository.getAllNotes()

    fun getImportantNotes() : LiveData<List<Notes>> = repository.getImportantNotes()

    fun getNormalNotes() : LiveData<List<Notes>> = repository.getNormalNotes()

    fun getCommonNotes() : LiveData<List<Notes>> = repository.getCommonNotes()

    fun deleteNotes (id:Int){
        repository.deleteNotes(id)

    }
    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }

    private val _name = MutableLiveData( "Develop By Daud Arya")

    val name : LiveData<String> = _name




    }


