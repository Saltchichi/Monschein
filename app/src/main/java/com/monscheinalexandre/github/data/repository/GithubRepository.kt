package com.monscheinalexandre.github.data.repository

import com.monscheinalexandre.github.data.api.GithubApi
import com.monscheinalexandre.github.data.model.GithubUserDetail
import com.monscheinalexandre.github.data.model.GithubUserShort
import com.monscheinalexandre.github.domain.model.UserDetail
import com.monscheinalexandre.github.domain.model.UserShort
import com.monscheinalexandre.github.domain.repository.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OmdbRepository: UserRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GithubApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(GithubApi::class.java)

    override suspend fun searchMovie(search: String): List<UserShort> {
        return api.searchUser(search).users.map {
            it.toUserShort()
        }
    }

    override suspend fun getMovieDetail(id: String): UserDetail {
        return api.getUserDetail(id).toUserDetail()
    }
}

fun GithubUserShort.toUserShort() = UserShort(this.id, this.username, this.avatar)

fun GithubUserDetail.toUserDetail() = UserDetail(
    this.username,
    this.avatar
)