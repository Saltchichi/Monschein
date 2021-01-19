package com.monscheinalexandre.github.domain.repository

import com.monscheinalexandre.github.domain.model.UserDetail
import com.monscheinalexandre.github.domain.model.UserShort

interface UserRepository {
    suspend fun searchUser(search : String) : List<UserShort>

    suspend fun getUserDetail(id :String) : UserDetail
}