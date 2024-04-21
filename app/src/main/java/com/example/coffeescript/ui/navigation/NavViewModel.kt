package com.example.coffeescript.ui.navigation

import androidx.lifecycle.ViewModel
import com.example.coffeescript.data.utils.NavDestinations
import com.example.coffeescript.repository.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferencesRepository
) : ViewModel() {
    val startDestination get() = if (sharedPreferences.hasToken) NavDestinations.Home else NavDestinations.Splash

}