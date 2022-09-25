package com.example.notes.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Model.Notes


@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes() : LiveData<List<Notes>>

    @Query("SELECT * FROM Notes Where priority =3")
    fun getImportantNotes() : LiveData<List<Notes>>

    @Query("SELECT * FROM Notes Where priority =2")
    fun getNormalNotes() : LiveData<List<Notes>>

    @Query("SELECT * FROM Notes Where priority =1")
    fun getCommonNotes() : LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("DELETE FROM Notes where id =:id")
    fun deleteNotes(id : Int)

    @Update
    fun updateNotes(notes: Notes)
}