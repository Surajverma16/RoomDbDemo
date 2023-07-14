package com.example.roomdbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.setTitle("User Data")
        setContentView(binding.root)
       /* val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"UserData"
        ).build()

        val userDao = db.userDao()
        val users : LiveData<List<UserDataClass>> = userDao.getALL()
*/
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, TabFragment())
            commit()
        }

    }

}