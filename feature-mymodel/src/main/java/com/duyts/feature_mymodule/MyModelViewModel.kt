package com.duyts.feature_mymodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duyts.core.data.repository.PropertyRepository
import com.duyts.core.model.Property
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyModelViewModel @Inject constructor(
    private val propertyRepository: PropertyRepository
) : ViewModel() {
    val uiState: StateFlow<MyModelUiState> = propertyRepository
        .getProperties().map<List<Property>, MyModelUiState> { MyModelUiState.Success(data = it) }
        .catch { emit(MyModelUiState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(500), MyModelUiState.Loading)


    fun addMyModel(title: String) {
        viewModelScope.launch {
            propertyRepository.createOne(Property(title = title))
        }
    }
}


sealed interface MyModelUiState {
    data object Loading : MyModelUiState
    data class Error(val throwable: Throwable) : MyModelUiState
    data class Success(val data: List<Property>) : MyModelUiState
}