package com.monscheinalexandre.github.data.model

import com.google.gson.annotations.SerializedName

data class GithubUserResponse(
    @SerializedName("Search")
    val users: List<GithubUserShort>,
    @SerializedName("totalResults")
    val resultNumber: Int,
)
