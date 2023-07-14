package com.example.roomdbdemo

import androidx.room.*


@Dao
interface UserDeo {

    @Query("SELECT * FROM userData")
     fun getALL(): List<UserDataClass>

    @Query("SELECT * FROM userData WHERE age > 50")
     fun getAgeAboveFifty() : List<UserDataClass>

    @Delete
     suspend fun deleteUser(user: UserDataClass)

    @Insert
     suspend fun insertUser(user: UserDataClass)

    @Update
     suspend fun updateUser(user: UserDataClass)


}


