package com.tick.secure.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.tick.secure.data.model.User

class LocalStorage(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("PasswordManager", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveUser(user: User) {
        val json = gson.toJson(user)
        sharedPreferences.edit().putString("user", json).apply()
    }

    fun getUser(): User? {
        val json = sharedPreferences.getString("user", null)
        return if (json != null) {
            gson.fromJson(json, User::class.java)
        } else {
            null
        }
    }
}