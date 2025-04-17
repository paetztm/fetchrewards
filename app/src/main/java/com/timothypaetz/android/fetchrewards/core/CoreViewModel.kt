package com.timothypaetz.android.fetchrewards.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel that handles UI state of Loading, Error, and Success
 * If your UI needs to call an Endpoint/IO work on load, this is the ViewModel to use
 *
 * This is overkill for an application with a single call like this Fetch exercise, however, if
 * you want to add more server calls for more screens, we can reuse this to reduce code
 */
open class CoreViewModel<T>(
    private val fetch: suspend () -> T?,
) : ViewModel() {

    private val _uiState: MutableStateFlow<CoreViewModelState<out T>> =
        MutableStateFlow(CoreViewModelState.Loading)
    val uiState: StateFlow<CoreViewModelState<out T>> = _uiState

    init {
        execute()
    }

    fun retry() {
        _uiState.value = CoreViewModelState.Loading
        execute(fetch)
    }

    private fun execute(fn: suspend () -> T? = fetch) {
        viewModelScope.launch {
            val response = fn()
            if (response != null) {
                _uiState.value = CoreViewModelState.Success(response)
            } else {
                _uiState.value = CoreViewModelState.Error
            }
        }
    }

}

sealed class CoreViewModelState<T> {
    data object Loading : CoreViewModelState<Nothing>()
    data object Error : CoreViewModelState<Nothing>()
    data class Success<T>(val result: T) : CoreViewModelState<T>()
}