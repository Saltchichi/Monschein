package com.monscheinalexandre.github.data.api

import com.monscheinalexandre.github.data.model.SearchResponse
import com.monscheinalexandre.github.data.model.GithubRepoShort
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("/search/users")
    suspend fun searchUser(
        @Query("q") login: String,
    ): SearchResponse

    @GET("/users/{login}/repos")
    suspend fun getUserRepo(
        @Path("login") login: String,
    ): List<GithubRepoShort>
    // https://api.github.com/users/Saltchichi/repos
}