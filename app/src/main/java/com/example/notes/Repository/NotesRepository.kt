package com.example.notes.Repository

import androidx.lifecycle.LiveData
import com.example.notes.Dao.NotesDao
import com.example.notes.Model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes() : LiveData<List<Notes>> = dao.getNotes()

    fun getImportantNotes() : LiveData<List<Notes>> = dao.getImportantNotes()

    fun getNormalNotes() : LiveData<List<Notes>> = dao.getNormalNotes()

    fun getCommonNotes() : LiveData<List<Notes>> = dao.getCommonNotes()


    fun inserNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }

}