package com.example.githubusersandroid.repositories

import com.example.githubusersandroid.models.User
import com.example.githubusersandroid.network.UserClient
import com.example.githubusersandroid.network.UserService
import retrofit2.Call

private const val TAG = "MainActivity"

class UserRepository {
    private val mClient: UserService = UserClient().getUsersAPI().build().create(UserService::class.java)

    fun getData(): Call<List<User>> {
        return mClient.getUsersList()
    }
}