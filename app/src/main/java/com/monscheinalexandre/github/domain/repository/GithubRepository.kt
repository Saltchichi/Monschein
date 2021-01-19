package com.monscheinalexandre.github.domain.repository

import com.monscheinalexandre.github.domain.model.RepoShort
import com.monscheinalexandre.github.domain.model.UserShort

interface GithubRepository {

    suspend fun searchUser(search: String): List<UserShort>

    suspend fun getRepositories(search: String): List<RepoShort>

}