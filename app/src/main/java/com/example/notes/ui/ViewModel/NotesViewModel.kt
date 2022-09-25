package com.example.notes.ui.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes.Database.NotesDatabase
import com.example.notes.Model.Notes
import com.example.notes.Repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val repository : NotesRepository

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
}