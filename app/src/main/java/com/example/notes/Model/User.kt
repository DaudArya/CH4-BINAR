package com.example.notes.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "User")
class User (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    @ColumnInfo(name = "app_name")
    val name : String?,
    @ColumnInfo(name = "email")
    val email : String?,
    @ColumnInfo(name = "username")
    val username : String?,
    @ColumnInfo(name = "password")
    val password : String?,
    @ColumnInfo(name = "address")
    val address : String?,
    @ColumnInfo(name = "dateofbirth")
    val born : String?
) : Serializable