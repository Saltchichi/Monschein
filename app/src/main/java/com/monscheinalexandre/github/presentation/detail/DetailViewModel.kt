package com.monscheinalexandre.github.presentation.detail

import androidx.lifecycle.*
import com.monscheinalexandre.github.domain.repository.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailViewModel : ViewModel() {

    private val repository: GithubRepository =
        com.monscheinalexandre.github.data.repository.GithubRepository()

    private val _state = MutableLiveData<DetailState>()
    val state: LiveData<DetailState> get() = _state

    fun findRepo(name: String) {
        _state.value = DetailState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = DetailState.SuccessState(repository.getRepositories(name))
            } catch (e: Exception) {
                _state.value = DetailState.ErrorState
            }
        }
    }
}