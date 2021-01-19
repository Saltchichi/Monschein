package com.monscheinalexandre.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubUserShort(
    @SerializedName("id")
    val id: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("avatar")
    val avatar: String,)
