package com.example.githubusersandroid.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id: Int,
    @SerializedName("login")
    var login: String,
    @SerializedName("avatar_url")
    var avatarUrl: String?,
    @SerializedName("html_url")
    var htmlUrl: String?,
    @SerializedName("blog")
    var blog: String?,
    @SerializedName("location")
    var location: String?,
    @SerializedName("followers")
    var followers: Int?,
    @SerializedName("following")
    var following: Int?,
    @SerializedName("name")
    var name: String?
)
