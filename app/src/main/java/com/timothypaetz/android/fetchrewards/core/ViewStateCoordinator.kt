package com.timothypaetz.android.fetchrewards.core

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.timothypaetz.android.fetchrewards.ui.theme.composables.ErrorRefresh
import com.timothypaetz.android.fetchrewards.ui.theme.composables.Loading

/**
 * Abstraction that calls a CoreViewModel and displays loading, error or onSuccess composable based
 * on state
 * If the endpoint errors out, it shows an Error Screen that allows the user to press Retry and it calls
 * CoreViewModel.retry()
 *
 * @param vm [CoreViewModel] that handles calling asynchronous tasks
 * @param onSuccess Composable that is displayed when ViewModel successfully returns results
 */

@Composable
fun <T> ViewStateCoordinator(
    vm: CoreViewModel<T>,
    loading: @Composable () -> Unit = { Loading() },
    error: @Composable () -> Unit = {
        ErrorRefresh {
            vm.retry()
        }
    },
    onSuccess: @Composable (T) -> Unit,
) {
    val uiState = vm.uiState.collectAsStateWithLifecycle().value
    when (uiState) {
        CoreViewModelState.Error -> error()
        CoreViewModelState.Loading -> loading()
        is CoreViewModelState.Success -> onSuccess(uiState.result)
    }
}