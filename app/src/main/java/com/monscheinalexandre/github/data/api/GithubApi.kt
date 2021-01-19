package com.monscheinalexandre.github.data.api

import com.monscheinalexandre.github.data.model.GithubUserDetail
import com.monscheinalexandre.github.data.model.GithubUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    companion object {
        const val BASE_URL = " https://developer.github.com/v3/search/"
    }

    @GET("/")
    suspend fun searchUser(
        @Query("s") title: String,
    ) : GithubUserResponse


    @GET("/")
    suspend fun getUserDetail(
        @Query("i") id: String,
    ) : GithubUserDetail
}