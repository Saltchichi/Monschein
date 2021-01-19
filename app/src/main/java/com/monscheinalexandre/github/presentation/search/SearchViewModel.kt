package com.monscheinalexandre.github.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monscheinalexandre.github.domain.repository.UserRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel {
    private val repository: UserRepository = GithubRepository()

    private val _state = MutableLiveData<SearchState>()
    val state : LiveData<SearchState> get() = _state

    fun searchMovie(text: String) {
        _state.value = SearchState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = SearchState.SuccessState(repository.searchUser(text))
            } catch (e: Exception) {
                _state.value = SearchState.ErrorState
            }
        }
    }
}