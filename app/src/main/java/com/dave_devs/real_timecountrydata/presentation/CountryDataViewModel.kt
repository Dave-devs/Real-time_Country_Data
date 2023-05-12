package com.dave_devs.real_timecountrydata.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dave_devs.real_timecountrydata.domain.use_case.GetCountryDataUseCase
import com.dave_devs.real_timecountrydata.domain.util.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountryDataViewModel @Inject constructor(
    private val getCountryDataUseCase: GetCountryDataUseCase
): ViewModel() {

    private val _uiState = mutableStateOf(CountryDataState())
    val uiState: State<CountryDataState> = _uiState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private var searchJob: Job? = null

    fun onSearch(name: String) {
        _searchQuery.value = name
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            getCountryDataUseCase(name).onEach { result->
              when(result) {
                  is Resource.Success -> {
                      _uiState.value = uiState.value.copy(
                         countryData = result.data?: emptyList(),
                          isLoading = false
                      )
                  }
                  is Resource.Loading -> {
                      _uiState.value = uiState.value.copy(
                          isLoading = true,
                          countryData = result.data?: emptyList()
                      )
                  }
                  is Resource.Error -> {
                      _uiState.value = uiState.value.copy(
                          countryData = result.data?: emptyList(),
                          isLoading = false
                      )
                      _eventFlow.emit(UiEvent.ShowSnackBar(
                          message = result.message?: "Unknown error occurred"
                      ))
                  }
              }
            }.launchIn(this)
        }
    }
}