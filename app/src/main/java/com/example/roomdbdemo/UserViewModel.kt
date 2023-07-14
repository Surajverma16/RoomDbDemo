package com.example.roomdbdemo

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UserViewModel(app: Application) : AndroidViewModel(app) {

    var allUser: MutableLiveData<List<UserDataClass>> = MutableLiveData()

    fun getUserObserver(): MutableLiveData<List<UserDataClass>> {
        return allUser
    }

    fun getAllUsers() {
        val userDao = AppDatabase.getDatabase(getApplication()).userDao()
        val list = userDao.getALL()
        allUser.value = list
    }

    fun insertUserInfo(userDataClass: UserDataClass) {
        viewModelScope.launch {
            val userData = AppDatabase.getDatabase(getApplication()).userDao()
            userData.insertUser(userDataClass)
            getAllUsers()
        }
    }

    fun deleteUserInfo(userDataClass: UserDataClass) {
        viewModelScope.launch {
            val userData = AppDatabase.getDatabase(getApplication()).userDao()
            userData.deleteUser(userDataClass)
            getAllUsers()
        }
    }

    fun updateUserInfo(userDataClass: UserDataClass) {
        viewModelScope.launch {
            val userData = AppDatabase.getDatabase(getApplication()).userDao()
            userData.updateUser(userDataClass)
            getAllUsers()
        }
    }
}












