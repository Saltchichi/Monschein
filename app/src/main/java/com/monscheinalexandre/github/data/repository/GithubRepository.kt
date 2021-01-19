package com.monscheinalexandre.github.data.repository

import com.monscheinalexandre.github.data.api.GithubApi
import com.monscheinalexandre.github.data.model.GithubUserShort
import com.monscheinalexandre.github.data.model.GithubRepoShort
import com.monscheinalexandre.github.domain.model.RepoShort
import com.monscheinalexandre.github.domain.model.UserShort
import com.monscheinalexandre.github.domain.repository.GithubRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository : GithubRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GithubApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(GithubApi::class.java)

    override suspend fun searchUser(search: String): List<UserShort> {
        return api.searchUser(search).users.map {
            it.toUserShort()
        }
    }

    override suspend fun getRepositories(name: String): List<RepoShort> {
        return api.getUserRepo(name).map {
            it.toRepoShort()
        }
    }
}

fun GithubUserShort.toUserShort() = UserShort(this.id, this.login, this.avatar)

fun GithubRepoShort.toRepoShort() = RepoShort(
    this.id,
    this.name,
    this.description,
    this.langage,
    this.forks,
    this.watchers,
)
