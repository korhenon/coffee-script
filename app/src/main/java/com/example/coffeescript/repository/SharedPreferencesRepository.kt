package com.example.coffeescript.repository

import com.example.coffeescript.data.service.ApiService
import com.example.coffeescript.data.service.SharedPreferencesService
import javax.inject.Inject

class SharedPreferencesRepository @Inject constructor(
    private val service: SharedPreferencesService
) {
    val hasToken get() = service.token != null
    val authorization get() = "Bearer " + service.token

    fun setToken(newToken: String) {
        service.token = newToken
    }

    fun removeToken() {
        service.token = null
    }
}