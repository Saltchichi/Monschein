package com.monscheinalexandre.github.presentation.detail

import com.monscheinalexandre.github.domain.model.RepoShort

sealed class DetailState {
    class SuccessState(val repos:List<RepoShort>) : DetailState()

    object ErrorState : DetailState()

    object LoadingState : DetailState()
}