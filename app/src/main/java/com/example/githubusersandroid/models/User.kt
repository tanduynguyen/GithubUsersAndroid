package com.example.githubusersandroid.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id: Int,
    @SerializedName("login")
    var login: String
//    let id: Int
//    let login: String
//    var avatar_url: URL?
//    var html_url: URL?
//    var blog: URL?
//    var location: String?
//    var followers: Int?
//    var following: Int?
//    var name: String?
)
