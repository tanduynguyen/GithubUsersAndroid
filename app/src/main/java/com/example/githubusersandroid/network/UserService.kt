package com.example.githubusersandroid.network

import com.example.githubusersandroid.helpers.Constants
import com.example.githubusersandroid.models.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET(Constants.pathUserURL)
    fun getUsersList(): Call<List<User>>
}