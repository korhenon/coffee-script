package com.example.coffeescript.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.coffeescript.data.models.LoginBody
import com.example.coffeescript.data.service.ApiService
import com.example.coffeescript.data.utils.NavDestinations
import com.example.coffeescript.repository.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val api: ApiService,
    private val sharedPreferences: SharedPreferencesRepository
): ViewModel() {
    var errorText by mutableStateOf("")
    var state by mutableStateOf(LoginState())

    fun login(navController: NavController) {
        viewModelScope.launch {
            try {
                val response = api.login(LoginBody(state.password, state.username))
                sharedPreferences.setToken(response.token)
                navController.navigate(NavDestinations.Home)
            } catch (ex: Exception) {
                errorText = if (ex.message != null) ex.message!! else "Error without message"
            }
        }
    }
}