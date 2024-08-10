package com.tick.secure.data.repository

import com.tick.secure.data.model.User
import com.tick.secure.util.HashUtil
import com.tick.secure.util.LocalStorage

class UserRepo(private val localStorage: LocalStorage) {
    fun registerUser(username: String, password: String): Boolean {
        val existingUser = localStorage.getUser()
        if (existingUser != null) {
            return false
        }
        val passwordHash = HashUtil.hashPassword(password)
        val user = User(username, passwordHash)
        localStorage.saveUser(user)
        return true
    }

    fun loginUser(username: String, password: String): Boolean {
        val user = localStorage.getUser()
        return user != null && user.username == username && HashUtil.verifyPassword(password, user.passwordHash)
    }
}