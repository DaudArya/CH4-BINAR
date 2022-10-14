package com.example.notes.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Model.User


@Dao
interface UserDao {

    @Query("SELECT * FROM Notes")
    fun getUser() : LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("DELETE FROM Notes where id =:id")
    fun deleteUser(id : Int)

    @Update
    fun updateUser(user: User)
}