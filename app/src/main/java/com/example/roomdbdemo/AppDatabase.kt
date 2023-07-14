package com.example.roomdbdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserDataClass::class], version = 1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDeo

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_database"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!

        }
    }
}