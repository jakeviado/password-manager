package com.tick.secure.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tick.secure.data.repository.UserRepo
import com.tick.secure.util.LocalStorage

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepo
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    init {
        val localStorage = LocalStorage(application)
        userRepository = UserRepo(localStorage)
    }

    fun loginUser(username: String, password: String) {
        val result = userRepository.loginUser(username, password)
        _loginResult.value = result
    }
}
