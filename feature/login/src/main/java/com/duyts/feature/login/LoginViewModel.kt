package com.duyts.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
	val loginUiState: StateFlow<LoginUiState> = flowOf("").map {
		LoginUiState.Success
	}.stateIn(
		scope = viewModelScope,
		started = SharingStarted.WhileSubscribed(5_0000),
		initialValue = LoginUiState.Loading
	)
}

sealed interface LoginUiState {
	data object Loading : LoginUiState
	data object Success : LoginUiState
}