package com.example.coffeescript.data.service

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesService @Inject constructor(
    @ApplicationContext context: Context
) {
    private val sp = context.getSharedPreferences("Coffee_script", Context.MODE_PRIVATE)

    var token: String?
        get() = sp.getString("TOKEN", null)
        set(value) {
            val editor = sp.edit()
            editor.putString("TOKEN", value)
            editor.apply()
        }
}