package com.monscheinalexandre.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubRepoShort(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("fork")
    val fork: String,
    @SerializedName("watchers")
    val watchers: String,
    @SerializedName("license")
    val license: String,
)
