package com.duyts.realestate.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duyts.realestate.ui.MainActivityUiState.Loading
import com.duyts.realestate.ui.MainActivityUiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
//    userDateRepository: UserDataRepository
) : ViewModel() {
    val uiState: StateFlow<MainActivityUiState> = flowOf("").map {
        Success
    }.stateIn(
        scope = viewModelScope,
        initialValue = Loading,
        started = SharingStarted.WhileSubscribed(5000)
    )
}

sealed interface MainActivityUiState {
    data object Success : MainActivityUiState
    data object Loading : MainActivityUiState
}
