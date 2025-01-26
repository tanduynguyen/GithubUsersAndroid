package com.example.githubusersandroid.repositories

import com.example.githubusersandroid.models.User
import com.example.githubusersandroid.network.UserClient
import com.example.githubusersandroid.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

private const val TAG = "MainActivity"

class UserRepository {
    private val mClient: UserService = UserClient().getUsersAPI().build().create(UserService::class.java)

    fun getData() {
        mClient.getUsersList().enqueue(object: Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users = response.body()
                users?.let {
                    for (user in it) {
                        Log.d(TAG, user.login)
                    }
                }
            }

            override fun onFailure(call: Call<List<User>>, error: Throwable) {
                error.localizedMessage?.let { Log.d(TAG, "Error: $it") }
            }
        })
    }
}