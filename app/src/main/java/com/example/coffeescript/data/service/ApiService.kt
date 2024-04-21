package com.example.coffeescript.data.service

import com.example.coffeescript.data.models.LoginBody
import com.example.coffeescript.data.models.LoginResponse
import com.example.coffeescript.data.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body body: LoginBody): LoginResponse

    @GET("user/me")
    suspend fun me(@Header("Authorization") authorization: String): User
}