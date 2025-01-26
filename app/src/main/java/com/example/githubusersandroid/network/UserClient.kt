package com.example.githubusersandroid.network

import com.example.githubusersandroid.helpers.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserClient {
    fun getUsersAPI(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.apiURLString)
            .addConverterFactory(GsonConverterFactory.create())
    }
}