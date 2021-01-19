package com.monscheinalexandre.github.presentation.detail

import com.monscheinalexandre.github.domain.model.UserDetail

sealed class DetailState {
    class SuccessState(val user:UserDetail) : DetailState()

    object ErrorState : DetailState()

    object LoadingState : DetailState()
}
