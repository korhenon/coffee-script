package com.example.coffeescript.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeescript.data.service.ApiService
import com.example.coffeescript.repository.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val api: ApiService,
    val sharedPreferences: SharedPreferencesRepository
): ViewModel() {
    var state by mutableStateOf(HomeState())

    fun load() {
        viewModelScope.launch {
            println(sharedPreferences.authorization)
            state = state.copy(me = api.me(sharedPreferences.authorization))
        }
    }
}