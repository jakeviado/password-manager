package com.tick.secure.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tick.secure.util.LocalStorage
import com.tick.secure.data.repository.UserRepo

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepo
    private val _registrationResult = MutableLiveData<Boolean>()
    val registrationResult: LiveData<Boolean> = _registrationResult

    init {
        val localStorage = LocalStorage(application)
        userRepository = UserRepo(localStorage)
    }

    fun registerUser(username: String, password: String, confirmPassword: String) {
        if (password != confirmPassword) {
            _registrationResult.value = false
            return
        }
        val result = userRepository.registerUser(username, password)
        _registrationResult.value = result
    }
}