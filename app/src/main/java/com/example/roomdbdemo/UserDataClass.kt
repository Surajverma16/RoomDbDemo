package com.example.roomdbdemo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userData")
data class UserDataClass(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name : String,
    val age : Int,
    val gender : String,
    val dob : Int
)
