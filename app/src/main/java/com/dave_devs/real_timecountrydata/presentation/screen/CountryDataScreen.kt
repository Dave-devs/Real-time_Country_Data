package com.dave_devs.real_timecountrydata.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDataScreen(
    modifier: Modifier = Modifier,
    viewModel: CountryDataViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.value
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event->
            when(event) {
                is UiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }
    
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {
        Box(
            modifier.background(MaterialTheme.colorScheme.background)
        ) {
            Column(modifier.fillMaxSize()) {
                TextField(
                    value = viewModel.searchQuery.value,
                    onValueChange = viewModel::onSearch,
                    modifier.fillMaxWidth(),
                    placeholder = { Text(text = "Search...") },
                    maxLines = 1,
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(modifier.fillMaxSize()) {
                    items(state.countryDataItems.size) {

                    }
//                    if(state.isLoading) {
//                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//                    }

                }
            }
        }
    }
    
}