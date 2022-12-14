package com.example.notes.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.Dao.NotesDao
import com.example.notes.Model.Notes

//User::class,
@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun myNotesDao() : NotesDao
//    abstract fun myUserDao() : UserDao


    companion object{
        @Volatile

        var INSTANCE : NotesDatabase? = null

        fun getDatabaseInstance(context: Context): NotesDatabase{
            val temInstance = INSTANCE
            if (temInstance != null ){
                return temInstance
            }
            synchronized(this){
                val roomDatabaseInstance = Room.databaseBuilder(context, NotesDatabase::class.java, "Notes").allowMainThreadQueries().build()
                INSTANCE=roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }
    }


}