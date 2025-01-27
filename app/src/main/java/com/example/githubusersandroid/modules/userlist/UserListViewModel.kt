package com.example.githubusersandroid.modules.userlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.githubusersandroid.models.User
import com.example.githubusersandroid.repositories.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "UserListViewModel"

class UserListViewModel: ViewModel() {
    val mUsers = MutableLiveData<List<User>>()

    init {
        getData()
    }

    private fun getData() {
        UserRepository().getData().enqueue(object: Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users = response.body()
                users?.let {
                    mUsers.value = it
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

    fun getUsers():MutableLiveData<List<User>> {
        return mUsers
    }

    // Define ViewModel factory in a companion object
    companion object {

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // Get the dependency in your factory
                UserListViewModel()
            }
        }
    }
}