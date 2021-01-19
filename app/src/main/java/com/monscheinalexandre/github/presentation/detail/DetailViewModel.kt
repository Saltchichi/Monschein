package com.monscheinalexandre.github.presentation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monscheinalexandre.github.domain.repository.UserRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository = GithubRepository()

    private val _state = MutableLiveData<DetailState>()
    val state: LiveData<DetailState> get() = _state

    fun getUserDetail(id: String) {
        _state.value = DetailState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = DetailState.SuccessState(repository.getUserDetail(id))
            } catch (e: Exception) {
                _state.value = DetailState.ErrorState
            }
        }
    }

}