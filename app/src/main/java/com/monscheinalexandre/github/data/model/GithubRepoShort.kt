package com.monscheinalexandre.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubRepoShort(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("language")
    val langage: String?,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("watchers")
    val watchers: Int,
)
