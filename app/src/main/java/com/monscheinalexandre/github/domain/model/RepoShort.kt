package com.monscheinalexandre.github.domain.model

data class RepoShort(
    val id: Int,
    val name: String,
    val description: String?,
    val langage: String?,
    val forks: Int,
    val watchers: Int,
)
